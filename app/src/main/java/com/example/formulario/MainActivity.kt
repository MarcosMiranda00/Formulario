package com.example.formulario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var txtNombre:EditText
    private lateinit var txtApellido:EditText
    private lateinit var spDepartamento:Spinner
    private lateinit var spMunicipio:Spinner
    private lateinit var txtTelefono:EditText
    private lateinit var rHombre:RadioButton
    private lateinit var rMujer:RadioButton
    private lateinit var txMostrar:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        txtNombre = findViewById(R.id.txtNombre)
        txtApellido = findViewById(R.id.txtApellido)
        rHombre = findViewById(R.id.rHombre)
        rMujer = findViewById(R.id.rMujer)
        txtTelefono = findViewById(R.id.txtTelefono)
        spDepartamento = findViewById(R.id.spDepartamento)
        spMunicipio = findViewById(R.id.spMunicipio)
        txMostrar = findViewById(R.id.txMostrar)

        val DepartamentosTodos = arrayOf("Chalatenango", "Santa Ana", "Ahuachapán", "Sonsonate", "San Salvador", "La Libertad", "Cuscatlán", "San Miguel", "Morazán", "San Vicente", "Usulután", "Cabañas", "La Paz", "La Unión")

        var datosSpinerDepartamento = ArrayAdapter(this, android.R.layout.simple_spinner_item, DepartamentosTodos)
        spDepartamento.adapter = datosSpinerDepartamento

        fun Municipiosall(department:String):ArrayList<String>{

            var ListadeMunicipios = arrayListOf<String>()

            when(department){
                "Chalatenango"->ListadeMunicipios.addAll(listOf("Agua Caliente","Arcatao","Azacualpa","Chalatenango","Citalá","Comalapa","Concepción Quezaltepeque",
                    "Dulce Nombre de María","El Carrizal","El Paraíso","La Laguna","La Palma","La Reina","Las Vueltas","Nombre de Jesús","Nueva Concepción",
                    "Nueva Trinidad","Ojos de Agua","Potonico","San Antonio de la Cruz","San Antonio Los Ranchos","San Fernando","San Francisco Lempa",
                    "San Francisco Morazán","San Ignacio","San Isidro Labrador","San José Cancasque (Cancasque)","San José Las Flores","San Luis del Carmen",
                    "San Miguel de Mercedes","San Rafael","Santa Rita","Tejutla"))
                "San Salvador"->ListadeMunicipios.addAll(listOf("Aguilares","Apopa","Ayutuxtepeque","Ciuddad Delgado","Cuscatancingo","El Paisnal","Guazapa","Ilopango",
                    "Mejicanos","Nejapa","Panchimalco","Rosario de Mora","San Marcos","San Martín","San Salvador","Santiago Texacuangos","Santo Tomás",
                    "Soyapango","Tonacatepeque"))
                "Sonsonate"->ListadeMunicipios.addAll(listOf("Acajutla","Armenia","Caluco","Cuisnahuat","Izalco","Juayúa","Nahuizalco","Nahulingo","Salcoatitán",
                    "San Antonio del Monte","San Julián","Santa Catarina Masahuat","Santa Isabel Ishuatán","Santo Domingo de Guzmán","Sonsonate",
                    "Sonzacate"))
                "La Paz"->ListadeMunicipios.addAll(listOf("Cuyultitán","El Rosario (Rosario de La Paz)","Jerusalén","Mercedes La Ceiba","Olocuilta","Paraíso de Osorio",
                    "San Antonio Masahuat","San Emigdio","San Francisco Chinameca","San Juan Nonualco","San Juan Talpa","San Juan Tepezontes",
                    "San Luis La Herradura","San Luis Talpa","San Miguel Tepezontes","San Pedro Masahuat","San Pedro Nonualco","San Rafael Obrajuelo",
                    "Santa María Ostuma","Santiago Nonualco","Tapalhuaca","Zacatecoluca"))
                "La Libertad"->ListadeMunicipios.addAll(listOf("Antiguo Cuscatlán","Chiltiupán","Ciudad Arce","Colón","Comasagua","Huizúcar","Jayaque","Jicalapa",
                    "La Libertad","Santa Tecla (Nueva San Salvador)","Nuevo Cuscatlán","San Juan Opico","Quezaltepeque","Sacacoyo",
                    "San José Villanueva","San Matías","San Pablo Tacachico","Talnique","Tamanique","Teotepeque","Tepecoyo","Zaragoza"))
                "San Miguel"->ListadeMunicipios.addAll(listOf("Carolina","Chapeltique","Chinameca","Chirilagua","Ciudad Barrios","Comacarán","El Tránsito","Lolotique",
                    "Moncagua","Nueva Guadalupe","Nuevo Edén de San Juan","Quelepa","San Antonio del Mosco","San Gerardo","San Jorge",
                    "San Luis de la Reina","San Miguel","San Rafael Oriente","Sesori","Uluazapa"))
                "Usulután"->ListadeMunicipios.addAll(listOf("Alegría","Berlín","California","Concepción Batres","El Triunfo","Ereguayquín","Estanzuelas","Jiquilisco",
                    "Jucuapa","Jucuarán","Mercedes Umaña","Nueva Granada","Ozatlán","Puerto El Triunfo","San Agustín","San Buenaventura",
                    "San Dionisio","San Francisco Javier","Santa Elena","Santa María","Santiago de María","Tecapán","Usulután"))
                "Cabañas"->ListadeMunicipios.addAll(listOf("Cinquera","Dolores (Villa Doleres)","Guacotecti","Ilobasco","Jutiapa","San Isidro",
                    "Sensuntepeque","Tejutepeque","Victoria"))
                "Santa Ana"->ListadeMunicipios.addAll(listOf("Candelaria de la Frontera","Chalchuapa","Coatepeque","El Congo","El Porvenir","Masahuat","Metapán",
                    "San Antonio Pajonal","San Sebastián Salitrillo","Santa Ana","Santa Rosa Guachipilín","Santiago de la Frontera","Texistepeque"))
                "San Vicente"->ListadeMunicipios.addAll(listOf("Apastepeque","Guadalupe","San Cayetano Istepeque","San Esteban Catarina","San Ildefonso","San Lorenzo",
                    "San Sebastián","San Vicente","Santa Clara","Santo Domingo","Tecoluca","Tepetitán","Verapaz"))
                "La Unión"->ListadeMunicipios.addAll(listOf("Anamorós","Bolívar","Concepción de Oriente","Conchagua","El Carmen","El Sauce","Intipucá","La Unión","Lilisque",
                    "Meanguera del Golfo","Nueva Esparta","Pasaquina","Polorós","San Alejo","San José","Santa Rosa de Lima","Yayantique","Yucuaiquín"))
                "Morazán"->ListadeMunicipios.addAll(listOf("Arambala","Cacaopera","Chilanga","Corinto","Delicias de Concepción","El Divisadero","El Rosario","Gualococti",
                    "Guatajiagua","Joateca","Jocoaitique","Jocoro","Lolotiquillo","Meanguera","Osicala","Perquín","San Carlos","San Fernando",
                    "San Francisco Gotera","San Isidro","San Simón","Sensembra","Sociedad","Torola","Yamabal","Yoloaiquín"))
                "Cuscatlán"->ListadeMunicipios.addAll(listOf("Candelaria","Cojutepeque","El Carmen","El Rosario","Monte San Juan","Oratorio de Concepción","San Bartolomé Perulapía",
                    "San Cristóbal","San José Guayabal","San Pedro Perulapán","San Rafael Cedros","San Ramón","Santa Cruz Analquito","Santa Cruz Michapa",
                    "Suchitoto","Tenancingo"))
                "Ahuachapán"->ListadeMunicipios.addAll(listOf("Ahuachapán","Apaneca","Atiquizaya","Concepción de Ataco","El Refugio","Guaymango","Jujutla",
                    "San Francisco Menéndez","San Lorenzo","San Pedro Puxtla","Tacuba","Turín"))
            }

            return ListadeMunicipios
        }
        spDepartamento?.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                var Departmento:String=spDepartamento.selectedItem.toString()
                val Municipios = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, Municipiosall(Departmento))
                spMunicipio.adapter = Municipios
            }
        }
    }


    var InformaciondelUsuario = arrayListOf<Array<String>>()

    fun GuardarInformacion(Save:View){

        var nombre = txtNombre.text.toString()
        var apellido = txtApellido.text.toString()
        var Telefono = txtTelefono.text.toString()
        var departament=spDepartamento.selectedItem.toString()
        var muncip=spMunicipio.selectedItem.toString()
        var sexo = ""

        if(rHombre.isChecked == true){
            sexo = "Masculino"
        }
        else if(rMujer.isChecked == true){
            sexo = "Femenino"
        }

        InformaciondelUsuario.clear()
        InformaciondelUsuario.addAll(listOf(arrayOf(nombre, apellido, Telefono, sexo, departament, muncip)))

        txMostrar.setText("")
        Toast.makeText(this, "¡Ud Guardo su Informacion con Exito!", Toast.LENGTH_SHORT).show()
    }


    fun MostrarInformacion(Show:View){

        for(i in 0..InformaciondelUsuario.size-1){
            txMostrar.append(InformaciondelUsuario[i].get(0).toString()+" \n"+InformaciondelUsuario[i].get(1).toString()+", con número \n"+
                    InformaciondelUsuario[i].get(2).toString()+" y sexo \n"+InformaciondelUsuario[i].get(3).toString()+", pertenece a \n"+InformaciondelUsuario[i].get(5).toString()+", \n"+
                    InformaciondelUsuario[i].get(4).toString()+".\n")
        }


        txtNombre.setText("")
        txtApellido.setText("")
            spDepartamento.setSelection(0)
            spMunicipio.setSelection(0)
            rMujer.isSelected=true
            rHombre.isSelected=true
            txtTelefono.setText("").toString()

    }
}