
INSERT INTO `gedbdd`.`profil` (`id_profil`, `nom`) VALUES (11,"USER");
INSERT INTO `gedbdd`.`profil` (`id_profil`, `nom`) VALUES (2,"ADMIN");
INSERT INTO `gedbdd`.`profil` (`id_profil`, `nom`) VALUES (3,"STAFF");


INSERT INTO `gedbdd`.`user` (`id_user`,`prenom`,`login`,`mdp`,`nom`) VALUES (1,"Franck","pichou","francky","TOUNGA");
INSERT INTO `gedbdd`.`user` (`id_user`,`prenom`,`login`,`mdp`,`nom`) VALUES (2,"Fred","freddy","moratta","BATANGA");
INSERT INTO `gedbdd`.`user` (`id_user`,`prenom`,`login`,`mdp`,`nom`) VALUES (3,"Paulin","gachette","sylvain","YOUMSI");


INSERT INTO `gedbdd`.`user_profil` (`id_user`,`id_profil`) VALUES (1,1);
INSERT INTO `gedbdd`.`user_profil` (`id_user`,`id_profil`) VALUES (1,3);
INSERT INTO `gedbdd`.`user_profil` (`id_user`,`id_profil`) VALUES (2,2);
INSERT INTO `gedbdd`.`user_profil` (`id_user`,`id_profil`) VALUES (3,3);
INSERT INTO `gedbdd`.`user_profil` (`id_user`,`id_profil`) VALUES (3,2);
INSERT INTO `gedbdd`.`user_profil` (`id_user`,`id_profil`) VALUES (3,1);



