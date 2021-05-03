package de.htwg.se.shutthebox.model.DAOComponent.DAObaseImpl

import slick.jdbc.MySQLProfile.api._

class FieldSchema(tag: Tag) extends Table[(Int, Boolean, Boolean, Boolean, Boolean, Boolean,
                                                Boolean, Boolean, Boolean, Boolean, Boolean,
                                                Boolean, Boolean)] (tag,"fieldtable") {

    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def stone1 = column[Boolean]("stone1")
    def stone2 = column[Boolean]("stone2")
    def stone3 = column[Boolean]("stone3")
    def stone4 = column[Boolean]("stone4")
    def stone5 = column[Boolean]("stone5")
    def stone6 = column[Boolean]("stone6")
    def stone7 = column[Boolean]("stone7")
    def stone8 = column[Boolean]("stone8")
    def stone9 = column[Boolean]("stone9")
    def stone10 = column[Boolean]("stone10")
    def stone11 = column[Boolean]("stone11")
    def stone12 = column[Boolean]("stone12")

    override def * =
        (id, stone1, stone2, stone3, stone4, stone5, stone6, stone7, stone8, stone9, stone10, stone11, stone12)

}
