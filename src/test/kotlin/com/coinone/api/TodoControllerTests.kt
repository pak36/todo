package com.coinone.api

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@ExtendWith(SpringExtension::class)
@WebMvcTest
class TodoControllerTests(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var todoRepository: TodoRepository

    @Test
    fun `List todos`() {
        val todo1 = Todo(1,"코틀린 공부하기", "코틀린 문법을 공부하자", false)
        val todo2 = Todo(2,"나는 공부중11", "공부 공부하11자", true)
        every { todoRepository.findAll() } returns listOf(todo1, todo2)

        mockMvc.perform(get("/todo/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("\$.[0].title").value("코틀린 공부하기"))
            .andExpect(jsonPath("\$.[0].description").value("코틀린 문법을 공부하자"))
    }

    @Test
    fun `get todo`() {

    }
}