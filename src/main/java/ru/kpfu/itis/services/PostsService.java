package ru.kpfu.itis.services;

import ru.kpfu.itis.models.entities.Post;

public interface PostsService {
    Iterable<Post> findAll();
}
