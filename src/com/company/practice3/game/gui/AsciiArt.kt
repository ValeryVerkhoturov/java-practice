package com.company.practice3.game.gui

object AsciiArt {
    @JvmField
    val baseAnimation = arrayOf(
"""         ((((
        ((((
         ))))
      _ .---.
     ( |`---'|
      \|     |
      : .___, :
       `-----'
персонаж набирается сил
 для будущих свершений""",
"""        ((((
       ((((
        ))))
      _ .---.
     ( |`---'|
      \|     |
      : .___, :
       `-----'
персонаж набирается сил
 для будущих свершений"""
    )
    const val autoExpedition =
"""            
           
            
      _ .---.
     ( |`---'|
      \|     |
      : .___, :
       `-----'
 ушел в автоэкспедицию 
 """
    @JvmField
    val deathAnimation = arrayOf(
"""          ______
       .-"      "-.
      /            \
     |              |
     |,  .-.  .-.  ,|
     | )(__/  \__)( |
     |/     /\     \|
     (_     ^^     _)
      \__|IIIIII|__/
       | \IIIIII/ |
       \          /
        `--------`

Веселый Роджер категорически
      приветствует Вас
""",
"""          ______
       .-"      "-.
      /            \
     |              |
     |,  .-.  .-.  ,|
     | )(__/  \__)( |
     |/     /\     \|
     (_     ^^     _)
      \__|IIIIII|__/
    
       | \IIIIII/ |
       \          /
        `--------`
Веселый Роджер категорически
      приветствует Вас
""",
    )
}