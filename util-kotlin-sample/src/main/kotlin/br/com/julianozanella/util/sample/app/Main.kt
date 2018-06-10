package br.com.julianozanella.util.sample.app

import br.com.julianozanella.util.Database
import br.com.julianozanella.util.exception.ConnectionNotFoundException
import br.com.julianozanella.util.sample.model.Person
import java.lang.reflect.InvocationTargetException
import java.sql.Date
import java.sql.SQLException
import java.util.ArrayList

/**
 *@author Juliano Zanella
 */


private const val URL = "jdbc:mysql://localhost:3306/personsDB"
private const val USER = "root"
private const val PASSWORD = ""


fun main(args: Array<String>) {
    try {
        Database.createConnection(URL, USER, PASSWORD)
        select()
        insert()
        select()
        update()
        select()
        delete()
        select()

    } catch (e: SQLException) {
        e.printStackTrace()
    } catch (e: ClassNotFoundException) {
        e.printStackTrace()
    } catch (e: ConnectionNotFoundException) {
        e.printStackTrace()
    } catch (e: IllegalAccessException) {
        e.printStackTrace()
    } catch (e: NoSuchMethodException) {
        e.printStackTrace()
    } catch (e: InvocationTargetException) {
        e.printStackTrace()
    } catch (e: InstantiationException) {
        e.printStackTrace()
    }

}

@Throws(ClassNotFoundException::class, SQLException::class, ConnectionNotFoundException::class, IllegalAccessException::class)
private fun insert() {
    val person = Person(1, "Foo", Date(2018, 6, 10), 'O')
    Database.insert(person)
    println("Inserted person: $person")
}

@Throws(ClassNotFoundException::class, SQLException::class, ConnectionNotFoundException::class, IllegalAccessException::class)
private fun update() {
    val person = Person(1, "Foo - Updated", Date(2015, 6, 10), 'O')
    Database.update(person)
    println("Updated person: $person")
}

@Throws(ClassNotFoundException::class, SQLException::class, ConnectionNotFoundException::class, IllegalAccessException::class)
private fun delete() {
    val person = Person()
    person.id = 1
    Database.delete(person)
    println("Deleted person: $person")
}


@Throws(IllegalAccessException::class, InvocationTargetException::class, InstantiationException::class, SQLException::class, ConnectionNotFoundException::class, NoSuchMethodException::class)
private fun select() {
    val persons = ArrayList<Person>()
    val objectList = Database.select(Person::class.java)
    for (`object` in objectList) {
        val p = `object` as Person
        persons.add(p)
    }
    printList(persons)

}

private fun printList(persons: List<Person>) {
    println("-----------------------")
    println("Printing all Persons:")
    println()
    for (person in persons) {
        println(person)
    }
    println("End of Persons List")
    println("-----------------------")
    println()

}

