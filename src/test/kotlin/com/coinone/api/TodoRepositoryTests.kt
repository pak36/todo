package com.coinone.api

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TodoRepositoryTests (@Autowired val todoRepository: TodoRepository) {

    @Test
    fun `inject`() {
        assertThat(todoRepository).isNotNull
    }

    @Test
    fun `Todo`() {
        val testTodo = Todo(1,"코틀린 공부하기", "코틀린 문법을 공부하자", false)
        val id :Long = 1
        val found = todoRepository.findById(id).get()
        assertThat(found).isEqualTo(testTodo)
    }

}
