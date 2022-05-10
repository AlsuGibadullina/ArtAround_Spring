package ru.kpfu.itis.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpfu.itis.models.entities.Post;

public interface PostsRepository extends CrudRepository<Post, Long> {
}
