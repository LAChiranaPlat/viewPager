package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewpager.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var layout:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        layout= ActivityMainBinding.inflate(layoutInflater)

        setContentView(layout.root)

        var lista:ArrayList<MyItems>
        lista= ArrayList()

        lista.add(MyItems("Iron Man","https://i0.wp.com/hipertextual.com/wp-content/uploads/2020/02/hipertextual-escenas-iron-man-y-avengers-endgame-que-significan-algo-muy-personal-robert-downey-jr-2020166600.jpg"))
        lista.add(MyItems("Capitan America","https://www.cinemascomics.com/wp-content/uploads/2020/07/chris-evans-capitan-america-peliculas-de-marvel.jpg"))
        lista.add(MyItems("Thor","https://i0.wp.com/hipertextual.com/wp-content/uploads/2022/01/avengers_infinity_war_joe_anthony_russo_4.jpg"))
        lista.add(MyItems("Hulk","https://www.enter.co/wp-content/uploads/2017/10/maxresdefault-1-1.jpg"))
        lista.add(MyItems("Hook Eye","https://as01.epimg.net/meristation/imagenes/2021/08/12/noticias/1628756545_243381_1628756761_noticia_normal.jpg"))
        lista.add(MyItems("Black Widow","https://www.nacion.com/resizer/RFBZHWHFAM6Wnj84hWM0fmiIvvs=/1440x0/filters:format(jpg):quality(70)/cloudfront-us-east-1.images.arcpublishing.com/gruponacion/SJDORKYZFNCBLEQZIAZUCWDV4M.jpg"))

        val vPager=layout.paginas
        val adaptador=adapterViewPager(lista)

        vPager.adapter=adaptador

        val _tabs=layout.tabs

        val _manager=TabLayoutMediator(_tabs,vPager,TabLayoutMediator.TabConfigurationStrategy{tab, position->

            when(position){

                0->tab.text="IronMan"
                1->tab.text="Capitan America"
                2->tab.text="Thor"
                3->tab.text="Hulk"
                4->tab.text="Ojo de Alcon"
                5->tab.text="Viuda Negra"

            }

        })

        _manager.attach()

    }
}