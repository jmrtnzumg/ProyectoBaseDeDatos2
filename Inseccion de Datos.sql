USE [BDBODEGAPEREZ]
GO
SET IDENTITY_INSERT [dbo].[CATEGORIA] ON 
GO
INSERT [dbo].[CATEGORIA] ([idcategoria], [nombre], [descripcion]) VALUES (9, N'BEBIDAS', N'GASEOSAS,HIDRATANTES,AGUA,ETC')
GO
INSERT [dbo].[CATEGORIA] ([idcategoria], [nombre], [descripcion]) VALUES (10, N'LICORES', N'VINOS,CERVESA,ETC')
GO
INSERT [dbo].[CATEGORIA] ([idcategoria], [nombre], [descripcion]) VALUES (11, N'DETERGENTES', N'JABONES,LEJIAS,ACE,ETC')
GO
INSERT [dbo].[CATEGORIA] ([idcategoria], [nombre], [descripcion]) VALUES (12, N'GOLOSINAS', N'GALLETAS,CARAMELOS, ETC')
GO
INSERT [dbo].[CATEGORIA] ([idcategoria], [nombre], [descripcion]) VALUES (13, N'LIMPIEZA', N'PASTA DENTAL,JABONSILLO,ETC')
GO
INSERT [dbo].[CATEGORIA] ([idcategoria], [nombre], [descripcion]) VALUES (14, N'ABCDE', N'FGHI')
GO
INSERT [dbo].[CATEGORIA] ([idcategoria], [nombre], [descripcion]) VALUES (15, N'DULCES', N'CHOCOLATES, DULCES')
GO
INSERT [dbo].[CATEGORIA] ([idcategoria], [nombre], [descripcion]) VALUES (16, N'CEREALES', N'AVENA, ARROZ, MAIZ, TRIGO')
GO
INSERT [dbo].[CATEGORIA] ([idcategoria], [nombre], [descripcion]) VALUES (17, N'EMBUTIDOS', N'SALCHICHAS, JAMON, PEPPERONI')
GO
INSERT [dbo].[CATEGORIA] ([idcategoria], [nombre], [descripcion]) VALUES (18, N'QUESOS', N'CHEDDAR, MOZARELLA, EMMENTAL')
GO
INSERT [dbo].[CATEGORIA] ([idcategoria], [nombre], [descripcion]) VALUES (19, N'LÁCTEOS', N'LECHE, CREMA, REQUESON')
GO
INSERT [dbo].[CATEGORIA] ([idcategoria], [nombre], [descripcion]) VALUES (20, N'OFICINA', N'PAPEL, TINTA, LAPICEROS')
GO
INSERT [dbo].[CATEGORIA] ([idcategoria], [nombre], [descripcion]) VALUES (21, N'PREPARADOS', N'SOPAS, FRIJOLES, SALSAS')
GO
INSERT [dbo].[CATEGORIA] ([idcategoria], [nombre], [descripcion]) VALUES (22, N'CARNES', N'CERDO, RES, POLLO, PESCADO')
GO
INSERT [dbo].[CATEGORIA] ([idcategoria], [nombre], [descripcion]) VALUES (23, N'CABELLO', N'SHAMPOO, ACONDICIONADOR')
GO
INSERT [dbo].[CATEGORIA] ([idcategoria], [nombre], [descripcion]) VALUES (24, N'CAFE', N'EN GRANO, INSTANTÁNEO')
GO
SET IDENTITY_INSERT [dbo].[CATEGORIA] OFF
GO
SET IDENTITY_INSERT [dbo].[MARCA] ON 
GO
INSERT [dbo].[MARCA] ([idmarca], [nombre]) VALUES (12, N'GLORIA')
GO
INSERT [dbo].[MARCA] ([idmarca], [nombre]) VALUES (13, N'NESTLE')
GO
INSERT [dbo].[MARCA] ([idmarca], [nombre]) VALUES (14, N'INKA KOLA')
GO
INSERT [dbo].[MARCA] ([idmarca], [nombre]) VALUES (15, N'OPAL')
GO
INSERT [dbo].[MARCA] ([idmarca], [nombre]) VALUES (16, N'COCA COLA')
GO
INSERT [dbo].[MARCA] ([idmarca], [nombre]) VALUES (17, N'NIR')
GO
INSERT [dbo].[MARCA] ([idmarca], [nombre]) VALUES (18, N'BORGOÑA')
GO
INSERT [dbo].[MARCA] ([idmarca], [nombre]) VALUES (19, N'LAYS')
GO
INSERT [dbo].[MARCA] ([idmarca], [nombre]) VALUES (20, N'NESCAFE')
GO
INSERT [dbo].[MARCA] ([idmarca], [nombre]) VALUES (21, N'FANTA')
GO
INSERT [dbo].[MARCA] ([idmarca], [nombre]) VALUES (22, N'GUARANA')
GO
INSERT [dbo].[MARCA] ([idmarca], [nombre]) VALUES (23, N'PEPSI')
GO
INSERT [dbo].[MARCA] ([idmarca], [nombre]) VALUES (24, N'RED BULL')
GO
INSERT [dbo].[MARCA] ([idmarca], [nombre]) VALUES (25, N'COLGATE')
GO
INSERT [dbo].[MARCA] ([idmarca], [nombre]) VALUES (26, N'CIELO')
GO
INSERT [dbo].[MARCA] ([idmarca], [nombre]) VALUES (27, N'NEKO')
GO
INSERT [dbo].[MARCA] ([idmarca], [nombre]) VALUES (30, N'PG')
GO
INSERT [dbo].[MARCA] ([idmarca], [nombre]) VALUES (31, N'PERU')
GO
SET IDENTITY_INSERT [dbo].[MARCA] OFF
GO
SET IDENTITY_INSERT [dbo].[PRODUCTO] ON 
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (52, N'GASEOSA', CAST(1.00 AS Decimal(16, 2)), CAST(2.00 AS Decimal(6, 2)), 68, CAST(N'2018-05-12' AS Date), 16, 9)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (53, N'ACE', CAST(2.00 AS Decimal(16, 2)), CAST(3.00 AS Decimal(6, 2)), 90, CAST(N'2018-06-15' AS Date), 15, 11)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (54, N'CERVEZA', CAST(5.00 AS Decimal(16, 2)), CAST(10.00 AS Decimal(6, 2)), 119, CAST(N'2018-07-23' AS Date), 16, 10)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (55, N'PURA VIDA', CAST(1.50 AS Decimal(16, 2)), CAST(3.00 AS Decimal(6, 2)), 115, CAST(N'2018-05-02' AS Date), 12, 9)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (56, N'IDEAL', CAST(2.50 AS Decimal(16, 2)), CAST(3.00 AS Decimal(6, 2)), 70, CAST(N'2018-12-04' AS Date), 18, 9)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (57, N'AGUA', CAST(1.00 AS Decimal(16, 2)), CAST(2.00 AS Decimal(6, 2)), 30, CAST(N'2017-12-03' AS Date), 26, 9)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (58, N'FANTA', CAST(1.00 AS Decimal(16, 2)), CAST(2.00 AS Decimal(6, 2)), 50, CAST(N'2017-12-04' AS Date), 21, 9)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (63, N'YOGURT 1L', CAST(3.00 AS Decimal(16, 2)), CAST(5.00 AS Decimal(6, 2)), 15, CAST(N'2018-08-17' AS Date), 12, 9)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (64, N'SPORADE 500 ML TROPICAL', CAST(1.50 AS Decimal(16, 2)), CAST(2.00 AS Decimal(6, 2)), 48, CAST(N'2020-12-19' AS Date), 16, 9)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (65, N'SIX PACK GALLO', CAST(33.00 AS Decimal(16, 2)), CAST(35.00 AS Decimal(6, 2)), 120, CAST(N'2021-12-31' AS Date), 19, 10)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (66, N'NESCAFÉ 225 G', CAST(35.00 AS Decimal(16, 2)), CAST(38.00 AS Decimal(6, 2)), 65, CAST(N'2021-12-31' AS Date), 20, 24)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (67, N'MULTI ABSORB', CAST(15.00 AS Decimal(16, 2)), CAST(18.40 AS Decimal(6, 2)), 35, CAST(N'2021-12-31' AS Date), 22, 14)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (68, N'PEPSI BLACK', CAST(8.00 AS Decimal(16, 2)), CAST(9.00 AS Decimal(6, 2)), 200, CAST(N'2021-12-31' AS Date), 23, 9)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (69, N'JABON LIQUIDO AVENA', CAST(20.00 AS Decimal(16, 2)), CAST(24.30 AS Decimal(6, 2)), 221, CAST(N'2021-12-31' AS Date), 25, 13)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (70, N'AGUA CIELO', CAST(3.00 AS Decimal(16, 2)), CAST(5.00 AS Decimal(6, 2)), 30, CAST(N'2021-12-31' AS Date), 26, 9)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (71, N'CAFÉ LA JARRILLITA', CAST(10.00 AS Decimal(16, 2)), CAST(15.00 AS Decimal(6, 2)), 90, CAST(N'2021-12-31' AS Date), 27, 24)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (72, N'PASTA DE TOMATE', CAST(3.00 AS Decimal(16, 2)), CAST(3.75 AS Decimal(6, 2)), 250, CAST(N'2021-12-31' AS Date), 14, 21)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (73, N'LECHE ENTERA', CAST(4.20 AS Decimal(16, 2)), CAST(5.00 AS Decimal(6, 2)), 200, CAST(N'2021-12-31' AS Date), 15, 19)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (74, N'GASEOSA LATA', CAST(5.00 AS Decimal(16, 2)), CAST(6.00 AS Decimal(6, 2)), 300, CAST(N'2021-12-31' AS Date), 16, 9)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (75, N'LECHE DESCREMADA', CAST(12.00 AS Decimal(16, 2)), CAST(15.00 AS Decimal(6, 2)), 100, CAST(N'2021-12-31' AS Date), 17, 19)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (76, N'RICO AL SARTEN', CAST(3.00 AS Decimal(16, 2)), CAST(5.00 AS Decimal(6, 2)), 50, CAST(N'2021-12-31' AS Date), 18, 21)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (77, N'PASTA CODITO', CAST(3.00 AS Decimal(16, 2)), CAST(3.50 AS Decimal(6, 2)), 100, CAST(N'2021-12-31' AS Date), 24, 21)
GO
INSERT [dbo].[PRODUCTO] ([idproducto], [nombre], [costo], [preciounit], [stock], [fecha_venci], [idmarca], [idcategoria]) VALUES (78, N'AVENA', CAST(18.00 AS Decimal(16, 2)), CAST(20.00 AS Decimal(6, 2)), 50, CAST(N'2021-12-31' AS Date), 21, 16)
GO
SET IDENTITY_INSERT [dbo].[PRODUCTO] OFF
GO
SET IDENTITY_INSERT [dbo].[CLIENTE] ON 
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [nombre], [telefono], [sexo], [fecha_naci], [direccion]) VALUES (12, N'12345678', N'DANIEL PEREZ CENTURION', N'947824723  ', N'M ', CAST(N'2017-11-30' AS Date), N'LOS PATOS')
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [nombre], [telefono], [sexo], [fecha_naci], [direccion]) VALUES (13, N'76991459', N'MABEL QUISPE OLIVERA', N'948769034  ', N'F ', CAST(N'1997-07-11' AS Date), N'JAEN')
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [nombre], [telefono], [sexo], [fecha_naci], [direccion]) VALUES (14, N'74668792', N'VICKY FERNANSEZ HERNANDEZ', N'966738921  ', N'F ', CAST(N'2000-11-30' AS Date), N'ICA')
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [nombre], [telefono], [sexo], [fecha_naci], [direccion]) VALUES (15, N'87654321', N'JOSE', N'976341234  ', N'M ', CAST(N'1999-12-01' AS Date), N'CHICLAYO')
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [nombre], [telefono], [sexo], [fecha_naci], [direccion]) VALUES (16, N'78653422', N'LUCERO DIAZ TELLO', N'936728983  ', N'F ', CAST(N'2000-12-01' AS Date), N'PUNO')
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [nombre], [telefono], [sexo], [fecha_naci], [direccion]) VALUES (17, N'73607301', N'NEYSER PEREZ PEREZ', N'935671855  ', N'F ', CAST(N'2002-01-20' AS Date), N'JR.SANTOS CHOCANO')
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [nombre], [telefono], [sexo], [fecha_naci], [direccion]) VALUES (18, N'77071240', N'KELION ENDE TADEO SANTOS', N'977192433  ', N'M ', CAST(N'1999-12-06' AS Date), N'HUANUCO')
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [nombre], [telefono], [sexo], [fecha_naci], [direccion]) VALUES (19, N'77071340', N'TADEO', N'988786566  ', N'F ', CAST(N'2017-12-06' AS Date), N'HUACI')
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [nombre], [telefono], [sexo], [fecha_naci], [direccion]) VALUES (27, N'0       ', N'TRANSEUNTE', N'95262002   ', N'F ', CAST(N'2017-12-20' AS Date), N'NR')
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [nombre], [telefono], [sexo], [fecha_naci], [direccion]) VALUES (28, N'73783779', N'KELION TADEO SANTOS', N'936278738  ', N'M ', CAST(N'2017-12-20' AS Date), N'HUANUCO')
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [nombre], [telefono], [sexo], [fecha_naci], [direccion]) VALUES (29, N'98503827', N'GEYSER ANGASPILCO', N'974665763  ', N'M ', CAST(N'2000-12-20' AS Date), N'CUTERVO')
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [nombre], [telefono], [sexo], [fecha_naci], [direccion]) VALUES (30, N'45768723', N'ARON DIAZ', N'95632147   ', N'M ', CAST(N'2000-07-14' AS Date), N'CHICLAYO')
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [nombre], [telefono], [sexo], [fecha_naci], [direccion]) VALUES (36, N'68574544', N'MARIANA VELA', N'78457894   ', N'F ', CAST(N'1990-03-25' AS Date), N'IZABAL')
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [nombre], [telefono], [sexo], [fecha_naci], [direccion]) VALUES (40, N'35798655', N'CELESTE LUCERO', N'22447788   ', N'F ', CAST(N'1970-05-14' AS Date), N'TOTONICAPAN')
GO
INSERT [dbo].[CLIENTE] ([idcliente], [dni], [nombre], [telefono], [sexo], [fecha_naci], [direccion]) VALUES (42, N'24478844', N'HECTOR CRUZ', N'22336547   ', N'M ', CAST(N'1986-09-12' AS Date), N'CHIQUIMULA')
GO
SET IDENTITY_INSERT [dbo].[CLIENTE] OFF
GO
SET IDENTITY_INSERT [dbo].[CARGO] ON 
GO
INSERT [dbo].[CARGO] ([idcargo], [nombre]) VALUES (1, N'ADMINISTRADOR')
GO
INSERT [dbo].[CARGO] ([idcargo], [nombre]) VALUES (2, N'VENDEDOR')
GO
INSERT [dbo].[CARGO] ([idcargo], [nombre]) VALUES (3, N'CAJERO')
GO
INSERT [dbo].[CARGO] ([idcargo], [nombre]) VALUES (7, N'GERENTE')
GO
INSERT [dbo].[CARGO] ([idcargo], [nombre]) VALUES (8, N'SECRETARIA')
GO
INSERT [dbo].[CARGO] ([idcargo], [nombre]) VALUES (9, N'CONTADOR')
GO
INSERT [dbo].[CARGO] ([idcargo], [nombre]) VALUES (10, N'ASISTENTE')
GO
INSERT [dbo].[CARGO] ([idcargo], [nombre]) VALUES (11, N'MONITOREO')
GO
INSERT [dbo].[CARGO] ([idcargo], [nombre]) VALUES (12, N'TRANSPORTE')
GO
INSERT [dbo].[CARGO] ([idcargo], [nombre]) VALUES (13, N'LIMPIEZA')
GO
INSERT [dbo].[CARGO] ([idcargo], [nombre]) VALUES (14, N'BODEGUERO')
GO
INSERT [dbo].[CARGO] ([idcargo], [nombre]) VALUES (15, N'COLOCADOR')
GO
INSERT [dbo].[CARGO] ([idcargo], [nombre]) VALUES (16, N'PRODUCCION')
GO
INSERT [dbo].[CARGO] ([idcargo], [nombre]) VALUES (17, N'LOGISTICA')
GO
INSERT [dbo].[CARGO] ([idcargo], [nombre]) VALUES (18, N'MARKETING')
GO
SET IDENTITY_INSERT [dbo].[CARGO] OFF
GO
SET IDENTITY_INSERT [dbo].[EMPLEADO] ON 
GO
INSERT [dbo].[EMPLEADO] ([idempleado], [dni], [nombre], [telefono], [sexo], [direccion], [fecha_ingreso], [salario], [idcargo], [clave]) VALUES (1, N'76991459', N'MABEL QUISPE OLIVERA', N'935531937  ', N'M ', N'AV. MARIANO MELGAR', CAST(N'2017-12-01' AS Date), CAST(774.00 AS Decimal(7, 2)), 1, N'123       ')
GO
INSERT [dbo].[EMPLEADO] ([idempleado], [dni], [nombre], [telefono], [sexo], [direccion], [fecha_ingreso], [salario], [idcargo], [clave]) VALUES (2, N'73577642', N'LID LLANIRA FERNANDEZ SANDOVAL', N'948769034  ', N'M ', N'AV. LAS PALMERAS2', CAST(N'2017-02-12' AS Date), CAST(775.00 AS Decimal(7, 2)), 2, N'1234      ')
GO
INSERT [dbo].[EMPLEADO] ([idempleado], [dni], [nombre], [telefono], [sexo], [direccion], [fecha_ingreso], [salario], [idcargo], [clave]) VALUES (5, N'22447781', N'LUCAS MUÑOS', N'457874166  ', N'M ', N'ZONA 10', CAST(N'2019-06-14' AS Date), CAST(1500.00 AS Decimal(7, 2)), 2, N'12345     ')
GO
INSERT [dbo].[EMPLEADO] ([idempleado], [dni], [nombre], [telefono], [sexo], [direccion], [fecha_ingreso], [salario], [idcargo], [clave]) VALUES (11, N'54646654', N'ANIBAL MENCOS', N'325458989  ', N'M ', N'ZONA 1', CAST(N'2020-05-03' AS Date), CAST(7500.00 AS Decimal(7, 2)), 7, N'123456    ')
GO
INSERT [dbo].[EMPLEADO] ([idempleado], [dni], [nombre], [telefono], [sexo], [direccion], [fecha_ingreso], [salario], [idcargo], [clave]) VALUES (12, N'45787815', N'CECILIA GIRON', N'561548514  ', N'F ', N'ZONA 17', CAST(N'2016-03-12' AS Date), CAST(1500.00 AS Decimal(7, 2)), 2, N'2345      ')
GO
INSERT [dbo].[EMPLEADO] ([idempleado], [dni], [nombre], [telefono], [sexo], [direccion], [fecha_ingreso], [salario], [idcargo], [clave]) VALUES (13, N'41457845', N'GENARO MALDONADO', N'654564654  ', N'M ', N'ZONA 2', CAST(N'2020-04-15' AS Date), CAST(1500.00 AS Decimal(7, 2)), 2, N'234578    ')
GO
INSERT [dbo].[EMPLEADO] ([idempleado], [dni], [nombre], [telefono], [sexo], [direccion], [fecha_ingreso], [salario], [idcargo], [clave]) VALUES (15, N'12454878', N'FERNANDO ZURDO', N'123545263  ', N'M ', N'ZONA 3', CAST(N'2019-03-03' AS Date), CAST(2500.00 AS Decimal(7, 2)), 10, N'45678     ')
GO
INSERT [dbo].[EMPLEADO] ([idempleado], [dni], [nombre], [telefono], [sexo], [direccion], [fecha_ingreso], [salario], [idcargo], [clave]) VALUES (18, N'97418157', N'SOFIA MANUEL', N'451878164  ', N'F ', N'ZONA 4', CAST(N'2021-01-16' AS Date), CAST(2000.00 AS Decimal(7, 2)), 11, N'234       ')
GO
INSERT [dbo].[EMPLEADO] ([idempleado], [dni], [nombre], [telefono], [sexo], [direccion], [fecha_ingreso], [salario], [idcargo], [clave]) VALUES (19, N'78154787', N'BYRON LORENZO', N'645787811  ', N'M ', N'ZONA 18', CAST(N'2018-03-24' AS Date), CAST(1500.00 AS Decimal(7, 2)), 12, N'12345     ')
GO
INSERT [dbo].[EMPLEADO] ([idempleado], [dni], [nombre], [telefono], [sexo], [direccion], [fecha_ingreso], [salario], [idcargo], [clave]) VALUES (20, N'87418484', N'SUCELY GARCI', N'644654784  ', N'F ', N'ZONA 10', CAST(N'2016-06-01' AS Date), CAST(1500.00 AS Decimal(7, 2)), 2, N'456       ')
GO
INSERT [dbo].[EMPLEADO] ([idempleado], [dni], [nombre], [telefono], [sexo], [direccion], [fecha_ingreso], [salario], [idcargo], [clave]) VALUES (21, N'65544169', N'ALMA ROCA', N'356755578  ', N'F ', N'ZONA 14', CAST(N'2017-11-04' AS Date), CAST(1500.00 AS Decimal(7, 2)), 2, N'789       ')
GO
INSERT [dbo].[EMPLEADO] ([idempleado], [dni], [nombre], [telefono], [sexo], [direccion], [fecha_ingreso], [salario], [idcargo], [clave]) VALUES (22, N'97946479', N'CRIS PEREZ', N'756646457  ', N'M ', N'ZONA 3', CAST(N'2018-05-16' AS Date), CAST(2000.00 AS Decimal(7, 2)), 13, N'789       ')
GO
INSERT [dbo].[EMPLEADO] ([idempleado], [dni], [nombre], [telefono], [sexo], [direccion], [fecha_ingreso], [salario], [idcargo], [clave]) VALUES (23, N'69325465', N'ABEL QUINTANA', N'34476567   ', N'M ', N'ZONA 6', CAST(N'2020-01-30' AS Date), CAST(2500.00 AS Decimal(7, 2)), 16, N'963       ')
GO
INSERT [dbo].[EMPLEADO] ([idempleado], [dni], [nombre], [telefono], [sexo], [direccion], [fecha_ingreso], [salario], [idcargo], [clave]) VALUES (25, N'97641647', N'SALLY ROCKFELLER', N'98952679   ', N'F ', N'ZONA 2', CAST(N'2016-05-17' AS Date), CAST(6500.00 AS Decimal(7, 2)), 18, N'633       ')
GO
INSERT [dbo].[EMPLEADO] ([idempleado], [dni], [nombre], [telefono], [sexo], [direccion], [fecha_ingreso], [salario], [idcargo], [clave]) VALUES (26, N'46479677', N'SERGIO PEREZ', N'85187447   ', N'M ', N'ZONA 1', CAST(N'2021-04-30' AS Date), CAST(6000.00 AS Decimal(7, 2)), 18, N'632       ')
GO
SET IDENTITY_INSERT [dbo].[EMPLEADO] OFF
GO
INSERT [dbo].[VENTA] ([numventa], [fecha], [idempleado], [idcliente]) VALUES (N'0001', CAST(N'2017-12-17' AS Date), 2, 12)
GO
INSERT [dbo].[VENTA] ([numventa], [fecha], [idempleado], [idcliente]) VALUES (N'0002', CAST(N'2017-12-17' AS Date), 2, 13)
GO
INSERT [dbo].[VENTA] ([numventa], [fecha], [idempleado], [idcliente]) VALUES (N'0003', CAST(N'2017-12-17' AS Date), 2, 12)
GO
INSERT [dbo].[VENTA] ([numventa], [fecha], [idempleado], [idcliente]) VALUES (N'0004', CAST(N'2017-12-19' AS Date), 2, 12)
GO
INSERT [dbo].[VENTA] ([numventa], [fecha], [idempleado], [idcliente]) VALUES (N'0005', CAST(N'2017-12-20' AS Date), 2, 12)
GO
INSERT [dbo].[VENTA] ([numventa], [fecha], [idempleado], [idcliente]) VALUES (N'0006', CAST(N'2017-12-20' AS Date), 2, 12)
GO
INSERT [dbo].[VENTA] ([numventa], [fecha], [idempleado], [idcliente]) VALUES (N'0007', CAST(N'2017-12-20' AS Date), 1, 12)
GO
INSERT [dbo].[VENTA] ([numventa], [fecha], [idempleado], [idcliente]) VALUES (N'0008', CAST(N'2017-12-20' AS Date), 1, 12)
GO
INSERT [dbo].[VENTA] ([numventa], [fecha], [idempleado], [idcliente]) VALUES (N'0009', CAST(N'2017-12-20' AS Date), 1, 12)
GO
INSERT [dbo].[VENTA] ([numventa], [fecha], [idempleado], [idcliente]) VALUES (N'0010', CAST(N'2017-12-22' AS Date), 2, 27)
GO
INSERT [dbo].[VENTA] ([numventa], [fecha], [idempleado], [idcliente]) VALUES (N'0011', CAST(N'2018-01-22' AS Date), 2, 12)
GO
INSERT [dbo].[VENTA] ([numventa], [fecha], [idempleado], [idcliente]) VALUES (N'0012', CAST(N'2021-04-15' AS Date), 5, 15)
GO
INSERT [dbo].[VENTA] ([numventa], [fecha], [idempleado], [idcliente]) VALUES (N'0013', CAST(N'2021-05-12' AS Date), 2, 18)
GO
INSERT [dbo].[VENTA] ([numventa], [fecha], [idempleado], [idcliente]) VALUES (N'0014', CAST(N'2021-05-01' AS Date), 5, 19)
GO
INSERT [dbo].[VENTA] ([numventa], [fecha], [idempleado], [idcliente]) VALUES (N'0015', CAST(N'2021-04-29' AS Date), 20, 14)
GO
INSERT [dbo].[VENTA] ([numventa], [fecha], [idempleado], [idcliente]) VALUES (N'0016', CAST(N'2021-03-12' AS Date), 13, 16)
GO
INSERT [dbo].[DETALLE_VENTA] ([idventa], [idproducto], [cantidad], [precio]) VALUES (N'0001', 52, 1, CAST(2.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[DETALLE_VENTA] ([idventa], [idproducto], [cantidad], [precio]) VALUES (N'0001', 56, 1, CAST(2.80 AS Decimal(7, 2)))
GO
INSERT [dbo].[DETALLE_VENTA] ([idventa], [idproducto], [cantidad], [precio]) VALUES (N'0002', 53, 2, CAST(18.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[DETALLE_VENTA] ([idventa], [idproducto], [cantidad], [precio]) VALUES (N'0002', 63, 3, CAST(4.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[DETALLE_VENTA] ([idventa], [idproducto], [cantidad], [precio]) VALUES (N'0003', 52, 2, CAST(2.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[DETALLE_VENTA] ([idventa], [idproducto], [cantidad], [precio]) VALUES (N'0003', 54, 2, CAST(10.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[DETALLE_VENTA] ([idventa], [idproducto], [cantidad], [precio]) VALUES (N'0004', 55, 4, CAST(5.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[DETALLE_VENTA] ([idventa], [idproducto], [cantidad], [precio]) VALUES (N'0004', 64, 2, CAST(2.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[DETALLE_VENTA] ([idventa], [idproducto], [cantidad], [precio]) VALUES (N'0005', 56, 5, CAST(6.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[DETALLE_VENTA] ([idventa], [idproducto], [cantidad], [precio]) VALUES (N'0006', 57, 4, CAST(15.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[DETALLE_VENTA] ([idventa], [idproducto], [cantidad], [precio]) VALUES (N'0007', 58, 1, CAST(5.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[DETALLE_VENTA] ([idventa], [idproducto], [cantidad], [precio]) VALUES (N'0008', 63, 5, CAST(3.50 AS Decimal(7, 2)))
GO
INSERT [dbo].[DETALLE_VENTA] ([idventa], [idproducto], [cantidad], [precio]) VALUES (N'0009', 63, 1, CAST(5.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[DETALLE_VENTA] ([idventa], [idproducto], [cantidad], [precio]) VALUES (N'0009', 64, 2, CAST(20.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[DETALLE_VENTA] ([idventa], [idproducto], [cantidad], [precio]) VALUES (N'0010', 55, 1, CAST(3.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[DETALLE_VENTA] ([idventa], [idproducto], [cantidad], [precio]) VALUES (N'0010', 63, 1, CAST(5.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[DETALLE_VENTA] ([idventa], [idproducto], [cantidad], [precio]) VALUES (N'0011', 54, 2, CAST(10.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[DETALLE_VENTA] ([idventa], [idproducto], [cantidad], [precio]) VALUES (N'0011', 55, 1, CAST(3.00 AS Decimal(7, 2)))
GO
SET IDENTITY_INSERT [dbo].[COMPROBANTE] ON 
GO
INSERT [dbo].[COMPROBANTE] ([idcomprobante], [idtipocomprobante], [fecha], [idcliente], [idventa], [total]) VALUES (1, 1003, CAST(N'2021-05-20' AS Date), 111111, 120, CAST(150.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[COMPROBANTE] ([idcomprobante], [idtipocomprobante], [fecha], [idcliente], [idventa], [total]) VALUES (3, 11, CAST(N'2020-02-18' AS Date), 111158, 12, CAST(354.80 AS Decimal(7, 2)))
GO
INSERT [dbo].[COMPROBANTE] ([idcomprobante], [idtipocomprobante], [fecha], [idcliente], [idventa], [total]) VALUES (4, 20, CAST(N'2020-03-15' AS Date), 564789, 15, CAST(243.25 AS Decimal(7, 2)))
GO
INSERT [dbo].[COMPROBANTE] ([idcomprobante], [idtipocomprobante], [fecha], [idcliente], [idventa], [total]) VALUES (7, 35, CAST(N'2020-04-02' AS Date), 874515, 19, CAST(547.97 AS Decimal(7, 2)))
GO
INSERT [dbo].[COMPROBANTE] ([idcomprobante], [idtipocomprobante], [fecha], [idcliente], [idventa], [total]) VALUES (10, 48, CAST(N'2020-05-23' AS Date), 545411, 22, CAST(958.30 AS Decimal(7, 2)))
GO
INSERT [dbo].[COMPROBANTE] ([idcomprobante], [idtipocomprobante], [fecha], [idcliente], [idventa], [total]) VALUES (11, 53, CAST(N'2020-06-06' AS Date), 784315, 35, CAST(20.59 AS Decimal(7, 2)))
GO
INSERT [dbo].[COMPROBANTE] ([idcomprobante], [idtipocomprobante], [fecha], [idcliente], [idventa], [total]) VALUES (12, 80, CAST(N'2020-07-30' AS Date), 346741, 58, CAST(213.25 AS Decimal(7, 2)))
GO
INSERT [dbo].[COMPROBANTE] ([idcomprobante], [idtipocomprobante], [fecha], [idcliente], [idventa], [total]) VALUES (13, 96, CAST(N'2020-08-29' AS Date), 349715, 67, CAST(351.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[COMPROBANTE] ([idcomprobante], [idtipocomprobante], [fecha], [idcliente], [idventa], [total]) VALUES (14, 102, CAST(N'2020-09-12' AS Date), 784979, 75, CAST(100.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[COMPROBANTE] ([idcomprobante], [idtipocomprobante], [fecha], [idcliente], [idventa], [total]) VALUES (15, 135, CAST(N'2020-10-22' AS Date), 254789, 80, CAST(196.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[COMPROBANTE] ([idcomprobante], [idtipocomprobante], [fecha], [idcliente], [idventa], [total]) VALUES (16, 160, CAST(N'2020-11-25' AS Date), 124878, 91, CAST(64.64 AS Decimal(7, 2)))
GO
INSERT [dbo].[COMPROBANTE] ([idcomprobante], [idtipocomprobante], [fecha], [idcliente], [idventa], [total]) VALUES (17, 230, CAST(N'2020-12-31' AS Date), 784519, 106, CAST(128.00 AS Decimal(7, 2)))
GO
INSERT [dbo].[COMPROBANTE] ([idcomprobante], [idtipocomprobante], [fecha], [idcliente], [idventa], [total]) VALUES (19, 597, CAST(N'2021-01-17' AS Date), 249716, 198, CAST(256.56 AS Decimal(7, 2)))
GO
INSERT [dbo].[COMPROBANTE] ([idcomprobante], [idtipocomprobante], [fecha], [idcliente], [idventa], [total]) VALUES (20, 678, CAST(N'2021-03-03' AS Date), 457891, 206, CAST(512.56 AS Decimal(7, 2)))
GO
INSERT [dbo].[COMPROBANTE] ([idcomprobante], [idtipocomprobante], [fecha], [idcliente], [idventa], [total]) VALUES (21, 875, CAST(N'2021-04-01' AS Date), 842108, 309, CAST(1024.00 AS Decimal(7, 2)))
GO
SET IDENTITY_INSERT [dbo].[COMPROBANTE] OFF
GO
SET IDENTITY_INSERT [dbo].[PRODUCTOS] ON 
GO
INSERT [dbo].[PRODUCTOS] ([idproducto], [nombre], [costo], [preciounit], [stock], [marca], [categoria]) VALUES (1, N'Pato', CAST(12.00 AS Decimal(8, 2)), CAST(15.00 AS Decimal(8, 2)), 48, N'CPP', N'PINTURAS')
GO
INSERT [dbo].[PRODUCTOS] ([idproducto], [nombre], [costo], [preciounit], [stock], [marca], [categoria]) VALUES (2, N'AAAA', CAST(10.00 AS Decimal(8, 2)), CAST(15.00 AS Decimal(8, 2)), 25, N'BBB', N'CCC')
GO
SET IDENTITY_INSERT [dbo].[PRODUCTOS] OFF
GO
SET IDENTITY_INSERT [dbo].[TIPO_COMPROBANTE] ON 
GO
INSERT [dbo].[TIPO_COMPROBANTE] ([idtipocoprobante], [nombre]) VALUES (5, N'FACTURA   ')
GO
INSERT [dbo].[TIPO_COMPROBANTE] ([idtipocoprobante], [nombre]) VALUES (6, N'VOUCHER   ')
GO
INSERT [dbo].[TIPO_COMPROBANTE] ([idtipocoprobante], [nombre]) VALUES (8, N'ELECTRONI ')
GO
INSERT [dbo].[TIPO_COMPROBANTE] ([idtipocoprobante], [nombre]) VALUES (9, N'CREDITO   ')
GO
INSERT [dbo].[TIPO_COMPROBANTE] ([idtipocoprobante], [nombre]) VALUES (10, N'DEBITO    ')
GO
INSERT [dbo].[TIPO_COMPROBANTE] ([idtipocoprobante], [nombre]) VALUES (11, N'TRANSFER  ')
GO
INSERT [dbo].[TIPO_COMPROBANTE] ([idtipocoprobante], [nombre]) VALUES (12, N'CHEQUE    ')
GO
INSERT [dbo].[TIPO_COMPROBANTE] ([idtipocoprobante], [nombre]) VALUES (13, N'CUPONES   ')
GO
INSERT [dbo].[TIPO_COMPROBANTE] ([idtipocoprobante], [nombre]) VALUES (14, N'TARJETAREG')
GO
INSERT [dbo].[TIPO_COMPROBANTE] ([idtipocoprobante], [nombre]) VALUES (15, N'TARJETAPUN')
GO
INSERT [dbo].[TIPO_COMPROBANTE] ([idtipocoprobante], [nombre]) VALUES (16, N'INGRESO   ')
GO
INSERT [dbo].[TIPO_COMPROBANTE] ([idtipocoprobante], [nombre]) VALUES (17, N'EGRESOS   ')
GO
INSERT [dbo].[TIPO_COMPROBANTE] ([idtipocoprobante], [nombre]) VALUES (18, N'NOMINA    ')
GO
INSERT [dbo].[TIPO_COMPROBANTE] ([idtipocoprobante], [nombre]) VALUES (19, N'NOTA      ')
GO
INSERT [dbo].[TIPO_COMPROBANTE] ([idtipocoprobante], [nombre]) VALUES (20, N'PAGARE    ')
GO
SET IDENTITY_INSERT [dbo].[TIPO_COMPROBANTE] OFF
GO
SET IDENTITY_INSERT [dbo].[USUARIO] ON 
GO
INSERT [dbo].[USUARIO] ([idusuario], [dni], [nombre], [telefono], [cargo], [clave]) VALUES (1, N'34578921  ', N'JOSE PEREZ', N'94831287   ', N'ADMIN', N'1234')
GO
SET IDENTITY_INSERT [dbo].[USUARIO] OFF
GO
