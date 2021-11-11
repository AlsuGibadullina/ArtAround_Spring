package ru.kpfu.itis.services;

import ru.kpfu.itis.models.Post;

import java.util.List;

public interface PostsService {
    List<Post> findAll();
}
