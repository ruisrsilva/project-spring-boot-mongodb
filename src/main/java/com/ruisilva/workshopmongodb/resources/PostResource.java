package com.ruisilva.workshopmongodb.resources;

import com.ruisilva.workshopmongodb.domain.Post;
import com.ruisilva.workshopmongodb.domain.User;
import com.ruisilva.workshopmongodb.dto.UserDTO;
import com.ruisilva.workshopmongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    PostService postService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = postService.findById(id);

        return ResponseEntity.ok().body(obj);
    }
}
