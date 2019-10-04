package com.coinone.api

import org.springframework.data.repository.CrudRepository

interface TodoRepository : CrudRepository<Todo, Long>