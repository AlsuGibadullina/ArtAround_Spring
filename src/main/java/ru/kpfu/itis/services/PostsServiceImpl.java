package ru.kpfu.itis.services;

import ru.kpfu.itis.models.entities.Post;
import ru.kpfu.itis.repositories.PostsRepository;

public class PostsServiceImpl implements PostsService{

    private PostsRepository postsRepository;

    public PostsServiceImpl(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Override
    public Iterable<Post> findAll() {
        return postsRepository.findAll();
    }
}
