package com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.services;

import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.entities.Cart;
import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.repositories.ClientRepository;
import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.repositories.ProductRepository;
import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.entities.Client;
import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.entities.Product;
import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    public Cart addProductToCart(Long clientId, Long productId, Integer amount) {
        Optional<Client> client = clientRepository.findById(clientId);
        Optional<Product> product = productRepository.findById(productId);
        if (client.isPresent() & product.isPresent()) {
            Cart cart = new Cart();
            cart.setClient(client.get());
            cart.setProduct(product.get());
            cart.setPrice(product.get().getPrice());
            cart.setAmount(amount);
            cart.setDelivered(false);
            return cartRepository.save(cart);
        } else {
            throw new RuntimeException("Client or Product not found");
        }
    }

    public Cart removeProductFromCart(Long cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (cart.isPresent()) {
            cartRepository.deleteById(cartId);
            return cart.get();
        } else {
            throw new RuntimeException("Cart not found");
        }
    }

    public List<Cart> findByClientIdAndDelivered(Long clientId) {
        List<Cart> carts = cartRepository.findByClientIdAndDelivered(clientId, false);
        if (carts.isEmpty()) {
            throw new RuntimeException("Carts not found");
        } else {
            return carts;
        }
    }
}
