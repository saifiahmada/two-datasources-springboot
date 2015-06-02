/*!40000 DROP DATABASE IF EXISTS `db_primary`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `db_primary` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_primary`;

DROP TABLE IF EXISTS `barang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `barang` (
  `id` varchar(40) NOT NULL,
  `gambar` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


/*!40000 DROP DATABASE IF EXISTS `db_primary`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `db_secondary` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_secondary`;

DROP TABLE IF EXISTS `barang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `barang` (
  `id` varchar(40) NOT NULL,
  `gambar` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
