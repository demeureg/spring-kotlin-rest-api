package com.github.demeureguillaume.repository

import com.github.demeureguillaume.entity.Post
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "post", path = "post")
interface PostRepository : PagingAndSortingRepository<Post, Long>{
}