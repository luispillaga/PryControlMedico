INSERT INTO PACIENTE (IDPERSONA, APELLIDO, CEDULA, EMAIL, NACIMIENTO, NOMBRE, TELEFONO, ALERGIAS, TIPOSANGRE) VALUES (1,'Coloma Saltos', '0200431584', 'rolando@bye.com', '1965-05-18', 'Jaime Rolando', '0997854221', 'Ninguna', 'O+')
INSERT INTO PACIENTE (IDPERSONA, APELLIDO, CEDULA, EMAIL, NACIMIENTO, NOMBRE, TELEFONO, ALERGIAS, TIPOSANGRE) VALUES (2,'Romero Barrionuevo', '0200784851', 'cecilia@bye.com', '1968-10-25', 'Cecilia Verónica', '0994175369', 'Ninguna', 'A+')

INSERT INTO MEDICO (IDPERSONA, APELLIDO, CEDULA, EMAIL, NACIMIENTO, NOMBRE, TELEFONO, ESPECIALIDAD, LICENCIA) VALUES (1,'Ordóñez Fernández', '0502478112', 'santiago@iess.org', '1970-04-14', 'Santiago Felipe', '0997845112', 'Endocrinología', '4215')
INSERT INTO MEDICO (IDPERSONA, APELLIDO, CEDULA, EMAIL, NACIMIENTO, NOMBRE, TELEFONO, ESPECIALIDAD, LICENCIA) VALUES (2,'Torres Vélez', '0506489511', 'alejandra@iess.org', '1975-02-21', 'Alejandra Susana', '09964887415', 'Traumatología', '7845')

INSERT INTO VIAADMINISTRACION (IDVIAADMINISTRACION, NOMBRE, CATEGORIA) VALUES (1,'Vía oral', 'Vía digestiva')
INSERT INTO VIAADMINISTRACION (IDVIAADMINISTRACION, NOMBRE, CATEGORIA) VALUES (2,'Vía sublingual', 'Vía digestiva')
INSERT INTO VIAADMINISTRACION (IDVIAADMINISTRACION, NOMBRE, CATEGORIA) VALUES (3,'Vía gastroentérica', 'Vía digestiva')
INSERT INTO VIAADMINISTRACION (IDVIAADMINISTRACION, NOMBRE, CATEGORIA) VALUES (4,'Vía rectal', 'Vía digestiva')
INSERT INTO VIAADMINISTRACION (IDVIAADMINISTRACION, NOMBRE, CATEGORIA) VALUES (5,'Intravenosa', 'Vía parenteral')
INSERT INTO VIAADMINISTRACION (IDVIAADMINISTRACION, NOMBRE, CATEGORIA) VALUES (6,'Intraarterial', 'Vía parenteral')
INSERT INTO VIAADMINISTRACION (IDVIAADMINISTRACION, NOMBRE, CATEGORIA) VALUES (7,'Intramuscular', 'Vía parenteral')
INSERT INTO VIAADMINISTRACION (IDVIAADMINISTRACION, NOMBRE, CATEGORIA) VALUES (8,'Subcutánea', 'Vía parenteral')
INSERT INTO VIAADMINISTRACION (IDVIAADMINISTRACION, NOMBRE, CATEGORIA) VALUES (9,'Vía intratraqueal', 'Vía respiratoria')
INSERT INTO VIAADMINISTRACION (IDVIAADMINISTRACION, NOMBRE, CATEGORIA) VALUES (10,'Vía intraalveolar', 'Vía respiratoria')
INSERT INTO VIAADMINISTRACION (IDVIAADMINISTRACION, NOMBRE, CATEGORIA) VALUES (11,'Conjuntival', 'Vía tópica')
INSERT INTO VIAADMINISTRACION (IDVIAADMINISTRACION, NOMBRE, CATEGORIA) VALUES (12,'Oral', 'Vía tópica')
INSERT INTO VIAADMINISTRACION (IDVIAADMINISTRACION, NOMBRE, CATEGORIA) VALUES (13,'Urogenital', 'Vía tópica')
INSERT INTO VIAADMINISTRACION (IDVIAADMINISTRACION, NOMBRE, CATEGORIA) VALUES (14,'Vía oftálmica', 'Vía oftálmica')
INSERT INTO VIAADMINISTRACION (IDVIAADMINISTRACION, NOMBRE, CATEGORIA) VALUES (15,'Vía ótica', 'Vía ótica')
INSERT INTO VIAADMINISTRACION (IDVIAADMINISTRACION, NOMBRE, CATEGORIA) VALUES (16,'Vía percutánea', 'Vía percutánea')

INSERT INTO MEDICAMENTO (IDMEDICAMENTO, COMPONENTEACTIVO, CONCENTRACION, NOMBRECOMERCIAL, PRECIO, FECHACADUCIDAD, IDVIAADMINISTRACION) VALUES (1,'Parecetamol - Pseudoefedrina Clorhidrato - Clorfenamina Maleato', '100 ml', 'TrioVal', 3.50, NULL, 1)
INSERT INTO MEDICAMENTO (IDMEDICAMENTO, COMPONENTEACTIVO, CONCENTRACION, NOMBRECOMERCIAL, PRECIO, FECHACADUCIDAD, IDVIAADMINISTRACION) VALUES (2,'Ibuprofeno', '120 ml', 'Buprex Forte', 5.50, NULL, 1)
INSERT INTO MEDICAMENTO (IDMEDICAMENTO, COMPONENTEACTIVO, CONCENTRACION, NOMBRECOMERCIAL, PRECIO, FECHACADUCIDAD, IDVIAADMINISTRACION) VALUES (3,'', 'Q10', 'Immuvit Plus Q10', 15.00, NULL, 1)
INSERT INTO MEDICAMENTO (IDMEDICAMENTO, COMPONENTEACTIVO, CONCENTRACION, NOMBRECOMERCIAL, PRECIO, FECHACADUCIDAD, IDVIAADMINISTRACION) VALUES (4,'Mometasona Furoato - Clorhidrato Azelastina', '50mcg + 140mcg', 'Momate AZ', 7.50, NULL, 10)