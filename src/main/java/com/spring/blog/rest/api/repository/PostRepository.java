/*
The PostRepository interface serves as a contract that defines the methods for interacting with the
underlying database to perform CRUD (Create, Read, Update, Delete) operations on Post entities.

Let's delve deeper into its significance and usage:

Abstraction of Database Operations:
The primary purpose of PostRepository is to abstract away the details of how database operations are
performed. Developers don't need to write boilerplate code for CRUD operations; instead,
they can rely on methods provided by JpaRepository such as save, findById, findAll, delete, etc.

Type-Safe Queries:
Spring Data JPA generates queries at runtime based on method names defined in the repository interface.
This allows developers to write queries using method names, which are type-safe and checked at
compile-time.

For example, if you define a method findByTitle(String title) in the PostRepository interface,
Spring Data JPA automatically generates the corresponding SQL query to find posts by their titles
without requiring you to write the SQL query explicitly.


 */

package com.spring.blog.rest.api.repository;

import com.spring.blog.rest.api.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post,Long> {
}
