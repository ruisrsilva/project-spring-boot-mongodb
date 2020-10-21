package com.ruisilva.workshopmongodb.services;

import com.ruisilva.workshopmongodb.domain.Post;
import com.ruisilva.workshopmongodb.domain.User;
import com.ruisilva.workshopmongodb.dto.UserDTO;
import com.ruisilva.workshopmongodb.repository.PostRepository;
import com.ruisilva.workshopmongodb.repository.UserRepository;
import com.ruisilva.workshopmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        // adding 24h equivalent of milliseconds to max date
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);

        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
