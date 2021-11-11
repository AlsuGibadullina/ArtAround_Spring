package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.Auth;
import ru.kpfu.itis.models.Tag;

public interface TagsRepository extends CrudRepository{
    Tag findByTagId(Long id);
}
