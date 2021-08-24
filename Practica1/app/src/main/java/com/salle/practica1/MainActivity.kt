package com.salle.practica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.TextView
import kotlin.random.Random
import com.salle.practica1.Pet as Pet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var myDogs = arrayListOf(Dog("Luli",12, "Chihuahua"))
        //myPets.addAll(myDogs);
    }

    private lateinit var txvInfo: TextView
    var myPets = mutableListOf<Pet>()
    var id : Int = 0
    var objPet = Pet("",0,"","")

    fun showInformationPet( id : Int){
        txvInfo = findViewById(R.id.txvInfo)
        txvInfo.text = "Tu máscota es un: ${objPet.animal} \n Su nombre es ${objPet.name} tiene ${objPet.age} años \n:)"
    }

    fun makeSound(view: View) {
        var numero = Random.nextInt(0, 5)
        if(myPets.size != 0) {
            if (objPet.animal == "Perro") {
                var sounds = arrayListOf(
                    "WOOF WOOF ","GUAU GUAU ","AUUUUH AUUUUUH","GRRRRRR","MMMMMM MMMMMM"     )
                Toast.makeText(this, sounds[numero], Toast.LENGTH_LONG).show()
            } else {
                var sounds = arrayListOf(
                    "MIAU MIAU ","MEOW MEOW ",   "PURRRR PURRRR",   "MIAOW MIAOW",   "MIAUUUUUUU"    )
                Toast.makeText(this, sounds[numero], Toast.LENGTH_LONG).show()
            }
        }
    }

    fun play(view: View) {
        if(myPets.size != 0){
            var playes = arrayListOf("Esta jugando con la pelota","Esta jugando con su cola","Esta jugando con una bola de hilo", "Esta jugando con su comida", "Esta jugando con su dueño")
            var nume = Random.nextInt(0, 4)
            Toast.makeText(this, playes[nume], Toast.LENGTH_LONG).show()
        }

    }

    fun eat(view: View) {
        if(myPets.size != 0){
            var foods = arrayListOf("Esta comiendo croquetas","Esta comiendo salchicha","Esta comiendo arroz", "Esta tomando leche", "Esta comiendo su proteina")
            var nume = Random.nextInt(0, 4)
            Toast.makeText(this, foods[nume], Toast.LENGTH_LONG).show()
        }
    }

    fun createNewPet(view: View) {
        var names = arrayListOf("Pepito","Calcetin","Fufi","Chespirito","Cuki","Sanson","Buli","Tomas","Chess","Tontin")
        var raceDog = arrayListOf("Chihuhua","Pitbull","Pastor alemàn","Husky","Labrador","Pug","Bulldog","Terranova","Gran dànes","San Bernardo")
        var raceCat = arrayListOf("Gato Persa","Bengala","Siamés","Ragdoll","Fold Escoces","Siberano","Bombay","Azul ruso","Toyger","Burmés")

        var nume = Random.nextInt(0, 10)
        if(myPets.size % 2 == 0){
            var newPet = Dog(names[nume],nume,raceDog[nume])
            objPet = newPet
            myPets.add(newPet)
        }else{
            var newPet = Cat(names[nume],nume,raceCat[nume])
            myPets.add(newPet)
            objPet = newPet
        }
        showInformationPet(myPets.size-1)
    }

    fun getPreviousPet(view: View) {
        if(myPets.size != 0) {
            if (id < 0 || id > myPets.size - 1) {
                id = myPets.size - 1
            }
            objPet = myPets[id]
            showInformationPet(id)

            id = id - 1
        }
    }

    fun getNextPet(view: View) {
        if(myPets.size != 0) {
            if (id > myPets.size - 1 || id < 0) {
                id = 0
            }
            objPet = myPets[id]
            showInformationPet(id)
            id = id + 1
        }
    }
}

