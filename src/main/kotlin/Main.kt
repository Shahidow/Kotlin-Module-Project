import java.util.Scanner
fun main(args: Array<String>) {
    val note = ActionsApp()
    var exitApp = true
    println("Программа заметки запущена!")
    while(exitApp) {
        val scanner = Scanner(System.`in`)
        println("Введите команду:")
        note.printArchivesMenu()
        if(!(scanner.hasNextInt())) {
            println("Не корректный ввод! Введите число.")
        } else {
            val command = scanner.nextInt()
            when(command) {
                0 -> {
                    while(true) {
                        println("Введите название:")
                        val nameArchive = readln().trim()
                        if(nameArchive == "") {
                            println("Пустое имя недопустимо! Повторите попытку")
                        } else {

                            note.addArchive(nameArchive)
                            println("Архив $nameArchive создан")
                            break
                        }
                    }
                }
                note.archivesList.size + 1 -> exitApp=false
                else -> {
                    if(command>note.archivesList.size || command<0) {
                        println("Команда не найдена! Повторите попытку.")
                    } else {
                        var exitNote = true
                        while(exitNote){
                            println("Введите команду:")
                            note.printNotesMenu(command-1)
                            val scanner2 = Scanner(System.`in`)
                            if(!(scanner2.hasNextInt())) {
                                println("Не корректный ввод! Введите число.")
                            } else {
                                val command2 = scanner2.nextInt()
                                when(command2) {
                                    0 -> {
                                        while (true) {
                                            println("Введите название:")
                                            val nameNote = readln().trim()
                                            println("Введите текст:")
                                            val textNote = readln().trim()
                                            if (nameNote == "" || textNote == "") {
                                                println("Пустое имя недопустимо! Повторите попытку")
                                            } else {
                                                note.addNote(command - 1, nameNote, textNote)
                                                println("Заметка $nameNote создана")
                                                break
                                            }
                                        }
                                    }
                                    note.archivesList[command - 1].notesList.size + 1 -> exitNote = false
                                    else -> {
                                        if (command2>note.archivesList[command - 1].notesList.size || command2<0) {
                                            println("Команда не найдена! Повторите попытку.")
                                        } else {
                                            note.printNote(command - 1, command2 - 1)
                                            while (true){
                                                val closeNote = readln().trim()
                                                if (closeNote == "0") break else println("Не корректный ввод!")
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }
                }

            }
        }

    }



}