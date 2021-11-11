package ru.kpfu.itis.services;

import ru.kpfu.itis.models.Post;
import ru.kpfu.itis.repositories.PostsRepository;

import java.util.List;

public class PostsServiceImpl implements PostsService{

    private PostsRepository postsRepository;

    public PostsServiceImpl(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Override
    public List<Post> findAll() {
        return postsRepository.findAll();
    }
}
