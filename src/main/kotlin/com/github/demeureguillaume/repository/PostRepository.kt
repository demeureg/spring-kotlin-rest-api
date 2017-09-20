package com.github.demeureguillaume.repository

import com.github.demeureguillaume.entity.Post
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.history.RevisionRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource


@RepositoryRestResource(path="post", collectionResourceRel="post")
interface PostRepository : PagingAndSortingRepository<Post, Long>, RevisionRepository<Post, Long, Long> {

}