class ActionsApp {
    val archivesList: MutableList<Archive> = mutableListOf()

    fun addArchive(nameArchive: String){
        archivesList.add(Archive(nameArchive, mutableListOf()))
    }

    fun addNote(archiveNum: Int, headline: String, textNote: String){
        archivesList[archiveNum].notesList.add(Note(headline, textNote))
    }

    fun printArchivesMenu(){
        var archiveQty: Int = 0
        println("$archiveQty. Создать архив")
        for(archive in archivesList) {
            archiveQty++
            println("$archiveQty. ${archive.nameArchive}")
        }
        println("${archiveQty+1}. Выход")
    }

    fun printNotesMenu(archiveNum: Int){
        val archive = archivesList[archiveNum].notesList
        var notesQty: Int = 0
        println("$notesQty. Создать заметку")
        for(note in archive){
            notesQty++
            println("$notesQty. ${note.headline}")
        }
        println("${notesQty+1}. Выход")
    }

    fun printNote(archiveNum: Int, noteNum: Int){
        val name: String = archivesList[archiveNum].notesList[noteNum].headline
        val text: String = archivesList[archiveNum].notesList[noteNum].textNote
        println("$name\n\n$text\n\n0. Выход")
    }
}