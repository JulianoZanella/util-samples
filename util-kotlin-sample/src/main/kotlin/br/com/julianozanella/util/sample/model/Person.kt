package br.com.julianozanella.util.sample.model

import java.sql.Date

data class Person(var id: Int = 0,
             var name: String? = null,
             var birthDate: Date? = null,
             var sex: Char = ' ') {

    override fun toString(): String {
        return "Person(id=$id, name=$name, birthDate=$birthDate, sex=$sex)"
    }
}
