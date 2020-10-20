package com.ruisilva.workshopmongodb.config;

import com.ruisilva.workshopmongodb.domain.Post;
import com.ruisilva.workshopmongodb.domain.User;
import com.ruisilva.workshopmongodb.repository.PostRepository;
import com.ruisilva.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Maria Brown", "maria@gmail.com");
        User u2 = new User(null, "Alex Green", "alex@gmail.com");
        User u3 = new User(null, "Bob Grey", "bob@gmail.com");

        Post p1 = new Post(null, sdf.parse("21/03/2018"), "Viagem", "Vou para São Paulo!", u1);
        Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei com esta vista!", u1);

        userRepository.saveAll(Arrays.asList(u1,u2,u3));
        postRepository.saveAll(Arrays.asList(p1,p2));
    }
}
