package domain.database

import org.kodein.db.DB
import org.kodein.db.impl.open

fun createDB(filename: String) = DB.open(filename)
