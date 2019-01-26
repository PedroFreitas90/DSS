USE mydb;
-- povoamento componentes
-- Obrigatorios
INSERT INTO Componente VALUES ("Preto",true,150,25);
INSERT INTO Componente VALUES ("Cinzento",true,150,25);
INSERT INTO Componente VALUES ("Branco",true,150,25);
INSERT INTO Componente VALUES ("Vermelho",true,150,25);
INSERT INTO Componente VALUES ("Marron",true,150,25);
INSERT INTO Componente VALUES ("Azul",true,150,25);
INSERT INTO Componente VALUES ("Crayon",true,150,25);
INSERT INTO Componente VALUES ("Preto Mate",true,300,25);
INSERT INTO Componente VALUES ("v8",true,8000,20);
INSERT INTO Componente VALUES ("v12",true,10000,15);
INSERT INTO Componente VALUES ("v16",true,12000,10);
INSERT INTO Componente VALUES ("Pireli",true,500,30);
INSERT INTO Componente VALUES ("Michelin",true,650,25);
INSERT INTO Componente VALUES ("Continental",true,600,15);
INSERT INTO Componente VALUES ("Modelo1",true,600,50);
INSERT INTO Componente VALUES ("Modelo2",true,800,30);
INSERT INTO Componente VALUES ("Modelo3",true,1000,15);
-- Detalhes
INSERT INTO Componente VALUES ("parachoques1",false,200,18);
INSERT INTO Componente VALUES ("parachoques2",false,180,10);
INSERT INTO Componente VALUES ("parachoques3",false,240,15);
INSERT INTO Componente VALUES ("parachoques4",false,150,8);
INSERT INTO Componente VALUES ("estofos1",false,580,18);
INSERT INTO Componente VALUES ("estofos2",false,1250,10);
INSERT INTO Componente VALUES ("estofos3",false,980,15);
INSERT INTO Componente VALUES ("estofos4",false,1050,8);
INSERT INTO Componente VALUES ("luzesLED",false,250,18);
INSERT INTO Componente VALUES ("luzesNeon",false,299,18);
INSERT INTO Componente VALUES ("luzesHalogenas",false,410,18);
INSERT INTO Componente VALUES ("luzesFluorescentes",false,500,18);
INSERT INTO Componente VALUES ("Vidros Escurecidos",false,500,18);
INSERT INTO Componente VALUES ("Teto de Abrir",false,500,18);
-- Opcionais   
INSERT INTO Componente VALUES ("acoplamento",false,150,8);
INSERT INTO Componente VALUES ("alarme",false,600,8);
INSERT INTO Componente VALUES ("camara traseira",false,450,8);
INSERT INTO Componente VALUES ("Hi Fi",false,900,8);
INSERT INTO Componente VALUES ("caixa automatica",false,7500,8);
INSERT INTO Componente VALUES ("gps",false,499,8);
INSERT INTO Componente VALUES ("ar condicionado",false,650,8);
INSERT INTO Componente VALUES ("pack fumador",false,150,8);

-- Componentes Incompatíveis
INSERT INTO Incompativeis VALUES ("Preto","Cinzento");
INSERT INTO Incompativeis VALUES ("Preto","Branco");
INSERT INTO Incompativeis VALUES ("Preto","Vermelho");
INSERT INTO Incompativeis VALUES ("Preto","Crayon");
INSERT INTO Incompativeis VALUES ("Preto","Azul");
INSERT INTO Incompativeis VALUES ("Preto","Marron");
INSERT INTO Incompativeis VALUES ("Preto","Preto Mate");

INSERT INTO Incompativeis VALUES ("Cinzento","Preto");
INSERT INTO Incompativeis VALUES ("Cinzento","Branco");
INSERT INTO Incompativeis VALUES ("Cinzento","Vermelho");
INSERT INTO Incompativeis VALUES ("Cinzento","Crayon");
INSERT INTO Incompativeis VALUES ("Cinzento","Azul");
INSERT INTO Incompativeis VALUES ("Cinzento","Marron");
INSERT INTO Incompativeis VALUES ("Cinzento","Preto Mate");

INSERT INTO Incompativeis VALUES ("Branco","Preto");
INSERT INTO Incompativeis VALUES ("Branco","Cinzento");
INSERT INTO Incompativeis VALUES ("Branco","Vermelho");
INSERT INTO Incompativeis VALUES ("Branco","Crayon");
INSERT INTO Incompativeis VALUES ("Branco","Azul");
INSERT INTO Incompativeis VALUES ("Branco","Marron");
INSERT INTO Incompativeis VALUES ("Branco","Preto Mate");

INSERT INTO Incompativeis VALUES ("Vermelho","Preto");
INSERT INTO Incompativeis VALUES ("Vermelho","Cinzento");
INSERT INTO Incompativeis VALUES ("Vermelho","Branco");
INSERT INTO Incompativeis VALUES ("Vermelho","Crayon");
INSERT INTO Incompativeis VALUES ("Vermelho","Azul");
INSERT INTO Incompativeis VALUES ("Vermelho","Marron");
INSERT INTO Incompativeis VALUES ("Vermelho","Preto Mate");

INSERT INTO Incompativeis VALUES ("Crayon","Preto");
INSERT INTO Incompativeis VALUES ("Crayon","Cinzento");
INSERT INTO Incompativeis VALUES ("Crayon","Branco");
INSERT INTO Incompativeis VALUES ("Crayon","Vermelho");
INSERT INTO Incompativeis VALUES ("Crayon","Azul");
INSERT INTO Incompativeis VALUES ("Crayon","Marron");
INSERT INTO Incompativeis VALUES ("Crayon","Preto Mate");

INSERT INTO Incompativeis VALUES ("Azul","Preto");
INSERT INTO Incompativeis VALUES ("Azul","Cinzento");
INSERT INTO Incompativeis VALUES ("Azul","Branco");
INSERT INTO Incompativeis VALUES ("Azul","Vermelho");
INSERT INTO Incompativeis VALUES ("Azul","Crayon");
INSERT INTO Incompativeis VALUES ("Azul","Marron");
INSERT INTO Incompativeis VALUES ("Azul","Preto Mate");

INSERT INTO Incompativeis VALUES ("Marron","Preto");
INSERT INTO Incompativeis VALUES ("Marron","Cinzento");
INSERT INTO Incompativeis VALUES ("Marron","Branco");
INSERT INTO Incompativeis VALUES ("Marron","Vermelho");
INSERT INTO Incompativeis VALUES ("Marron","Crayon");
INSERT INTO Incompativeis VALUES ("Marron","Azul");
INSERT INTO Incompativeis VALUES ("Marron","Preto Mate");

INSERT INTO Incompativeis VALUES ("Preto Mate","Preto");
INSERT INTO Incompativeis VALUES ("Preto Mate","Cinzento");
INSERT INTO Incompativeis VALUES ("Preto Mate","Branco");
INSERT INTO Incompativeis VALUES ("Preto Mate","Vermelho");
INSERT INTO Incompativeis VALUES ("Preto Mate","Crayon");
INSERT INTO Incompativeis VALUES ("Preto Mate","Azul");
INSERT INTO Incompativeis VALUES ("Preto Mate","Marron");

INSERT INTO Incompativeis VALUES("v16","v8");
INSERT INTO Incompativeis VALUES("v12","v8");
INSERT INTO Incompativeis VALUES("v8","v12");
INSERT INTO Incompativeis VALUES("v16","v12");
INSERT INTO Incompativeis VALUES("v8","v16");
INSERT INTO Incompativeis VALUES("v12","v16");

INSERT INTO Incompativeis VALUES("Michelin","Pireli");
INSERT INTO Incompativeis VALUES("Continental","Pireli");
INSERT INTO Incompativeis VALUES("Pireli","Michelin");
INSERT INTO Incompativeis VALUES("Continental","Michelin");
INSERT INTO Incompativeis VALUES("Pireli","Continental");
INSERT INTO Incompativeis VALUES("Michelin","Continental");

INSERT INTO Incompativeis VALUES("Modelo2","Modelo1");
INSERT INTO Incompativeis VALUES("Modelo3","Modelo1");
INSERT INTO Incompativeis VALUES("Modelo1","Modelo2");
INSERT INTO Incompativeis VALUES("Modelo3","Modelo2");
INSERT INTO Incompativeis VALUES("Modelo1","Modelo3");
INSERT INTO Incompativeis VALUES("Modelo2","Modelo3");

INSERT INTO Incompativeis VALUES("estofos2","estofos1");
INSERT INTO Incompativeis VALUES("estofos3","estofos1");
INSERT INTO Incompativeis VALUES("estofos4","estofos1");

INSERT INTO Incompativeis VALUES("parachoques1","estofos2");
INSERT INTO Incompativeis VALUES("parachoques3","estofos2");
INSERT INTO Incompativeis VALUES("parachoques4","estofos2");
INSERT INTO Incompativeis VALUES("estofos1","estofos2");
INSERT INTO Incompativeis VALUES("estofos3","estofos2");
INSERT INTO Incompativeis VALUES("estofos4","estofos2");


INSERT INTO Incompativeis VALUES("estofos1","estofos3");
INSERT INTO Incompativeis VALUES("estofos2","estofos3");
INSERT INTO Incompativeis VALUES("estofos4","estofos3");


INSERT INTO Incompativeis VALUES("estofos1","estofos4");
INSERT INTO Incompativeis VALUES("estofos2","estofos4");
INSERT INTO Incompativeis VALUES("estofos3","estofos4");

INSERT INTO Incompativeis VALUES("luzesNeon","luzesLED");
INSERT INTO Incompativeis VALUES("luzesHalogenas","luzesLED");
INSERT INTO Incompativeis VALUES("luzesFluorescentes","luzesLED");

INSERT INTO Incompativeis VALUES("luzesLED","luzesNeon");
INSERT INTO Incompativeis VALUES("luzesHalogenas","luzesNeon");
INSERT INTO Incompativeis VALUES("luzesFluorescentes","luzesNeon");

INSERT INTO Incompativeis VALUES("luzesLED","luzesHalogenas");
INSERT INTO Incompativeis VALUES("luzesNeon","luzesHalogenas");
INSERT INTO Incompativeis VALUES("luzesFluorescentes","luzesHalogenas");


INSERT INTO Incompativeis VALUES("luzesLED","luzesFluorescentes");
INSERT INTO Incompativeis VALUES("luzesNeon","luzesFluorescentes");
INSERT INTO Incompativeis VALUES("luzesHalogenas","luzesFluorescentes");
INSERT INTO Incompativeis VALUES("estofos1","luzesFluorescentes");
INSERT INTO Incompativeis VALUES("estofos2","luzesFluorescentes");
INSERT INTO Incompativeis VALUES("estofos3","luzesFluorescentes");


INSERT INTO Incompativeis VALUES("parachoques2","parachoques1");
INSERT INTO Incompativeis VALUES("parachoques3","parachoques1");
INSERT INTO Incompativeis VALUES("parachoques4","parachoques1");

INSERT INTO Incompativeis VALUES("parachoques1","parachoques2");
INSERT INTO Incompativeis VALUES("parachoques3","parachoques2");
INSERT INTO Incompativeis VALUES("parachoques4","parachoques2");


INSERT INTO Incompativeis VALUES("parachoques1","parachoques3");
INSERT INTO Incompativeis VALUES("parachoques2","parachoques3");
INSERT INTO Incompativeis VALUES("parachoques4","parachoques3");


INSERT INTO Incompativeis VALUES("parachoques1","parachoques4");
INSERT INTO Incompativeis VALUES("parachoques2","parachoques4");
INSERT INTO Incompativeis VALUES("parachoques3","parachoques4");

INSERT INTO Incompativeis VALUES("gps","estofos1");
INSERT INTO Incompativeis VALUES("estofos1","gps");

INSERT INTO Incompativeis VALUES("luzesLED","estofos4");
INSERT INTO Incompativeis VALUES("estofos4","luzesLED");


INSERT INTO Incompativeis VALUES("Hi Fi","estofos3");
INSERT INTO Incompativeis VALUES("estofos3","Hi Fi");


INSERT INTO Incompativeis VALUES("luzesNeon","pack fumador");
INSERT INTO Incompativeis VALUES("pack fumador","luzesNeon");


-- Componentes Dependentes
INSERT INTO Dependentes VALUES("camara traseira","parachoques4");
INSERT INTO Dependentes VALUES("estofos4","luzesFluorescentes");
INSERT INTO Dependentes VALUES("caixa automatica","luzesNeon");
INSERT INTO Dependentes VALUES("parachoques2","estofos2");
INSERT INTO Dependentes VALUES("alarme","estofos2");


-- Pacotes
INSERT INTO Pacote VALUES (1,"Sport",0.15);
INSERT INTO Pacote VALUES (2,"Comfort",0.1);
INSERT INTO Pacote VALUES (3,"Tunning",0.05);

-- Componentes dos Pacotes
INSERT INTO Pacote_Componente VALUES(1,"estofos2");
INSERT INTO Pacote_Componente VALUES(1,"luzesHalogenas");
INSERT INTO Pacote_Componente VALUES(1,"parachoques2");

INSERT INTO Pacote_Componente VALUES(2,"estofos4");
INSERT INTO Pacote_Componente VALUES(2,"luzesFluorescentes");
INSERT INTO Pacote_Componente VALUES(2,"ar condicionado");
INSERT INTO Pacote_Componente VALUES(2,"gps");

INSERT INTO Pacote_Componente VALUES(3,"estofos3");
INSERT INTO Pacote_Componente VALUES(3,"luzesNeon");
INSERT INTO Pacote_Componente VALUES(3,"parachoques4");



-- Carros
INSERT INTO Carro VALUES(1,"Bmw Serie 1",20000);
INSERT INTO Carro VALUES(2,"Ford Mustang",25000);
INSERT INTO Carro VALUES(3,"Mercedez Benz classe A",19000);
INSERT INTO Carro VALUES(4,"Audi",30000);
INSERT INTO Carro VALUES(5,"Porsche Cayene",35000);
INSERT INTO Carro VALUES(6,"Range Rover",40000);

-- Funcionarios
INSERT INTO Funcionario VALUES("gestor", "admin");
INSERT INTO Funcionario VALUES("cyborg", "sii");
INSERT INTO Funcionario VALUES("Groot", "iam");
INSERT INTO Funcionario VALUES("Nikes", "doit");
INSERT INTO Funcionario VALUES("Sardao", "baba");
