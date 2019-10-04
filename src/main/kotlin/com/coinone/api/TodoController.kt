package com.coinone.api

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todo")
class TodoController(val todoRepository: TodoRepository) {
    @GetMapping
    fun getTodos(): MutableIterable<Todo> = todoRepository.findAll()

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.GET])
    fun getTodo(@PathVariable("id") todoId: Long):Optional<Todo>? {
        return todoRepository.findById(todoId)
    }

    @PostMapping
    fun newTodo(@RequestBody todo: Todo): Todo {
        todoRepository.save(todo)
        return todo
    }

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.PUT])
    @ResponseStatus(HttpStatus.OK)
    fun updateTodo(@RequestBody todo: Todo, @PathVariable("id") todoId: Long) {
        val target: Todo = todoRepository.findById(todoId).get()
        target.title = todo.title
        target.description = todo.description
        target.finished = todo.finished

        todoRepository.save(target)
    }

    @RequestMapping(path = ["/{id}"], method = [RequestMethod.DELETE])
    fun deleteTodo(@PathVariable("id") todoId: Long){
        todoRepository.deleteById(todoId)
    }
}
