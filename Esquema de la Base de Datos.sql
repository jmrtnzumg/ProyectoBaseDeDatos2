USE [master]
GO
/****** Object:  Database [BDBODEGAPEREZ]    Script Date: 31-May-21 10:16:39 PM ******/
CREATE DATABASE [BDBODEGAPEREZ]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BDBODEGAPEREZ', FILENAME = N'/var/opt/mssql/data/BDBODEGAPEREZ.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BDBODEGAPEREZ_log', FILENAME = N'/var/opt/mssql/data/BDBODEGAPEREZ_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [BDBODEGAPEREZ] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BDBODEGAPEREZ].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BDBODEGAPEREZ] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET ARITHABORT OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET RECOVERY FULL 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET  MULTI_USER 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BDBODEGAPEREZ] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BDBODEGAPEREZ] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'BDBODEGAPEREZ', N'ON'
GO
ALTER DATABASE [BDBODEGAPEREZ] SET QUERY_STORE = OFF
GO
USE [BDBODEGAPEREZ]
GO
/****** Object:  Table [dbo].[CATEGORIA]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CATEGORIA](
	[idcategoria] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](200) NOT NULL,
	[descripcion] [varchar](100) NOT NULL,
 CONSTRAINT [PK_CATEGORIA] PRIMARY KEY CLUSTERED 
(
	[idcategoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[V_MANTENIMIENTO_CATEGORIA]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_MANTENIMIENTO_CATEGORIA]
AS
SELECT        idcategoria, nombre, descripcion
FROM            dbo.CATEGORIA
GO
/****** Object:  Table [dbo].[PRODUCTO]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PRODUCTO](
	[idproducto] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](100) NOT NULL,
	[costo] [decimal](16, 2) NULL,
	[preciounit] [decimal](6, 2) NOT NULL,
	[stock] [int] NOT NULL,
	[fecha_venci] [date] NOT NULL,
	[idmarca] [int] NOT NULL,
	[idcategoria] [int] NOT NULL,
 CONSTRAINT [PK_PRODUCTO] PRIMARY KEY CLUSTERED 
(
	[idproducto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MARCA]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MARCA](
	[idmarca] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](100) NOT NULL,
 CONSTRAINT [PK_MARCA] PRIMARY KEY CLUSTERED 
(
	[idmarca] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[V_UTILIDAD]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_UTILIDAD]
AS
SELECT        dbo.PRODUCTO.idproducto, dbo.PRODUCTO.nombre, dbo.PRODUCTO.costo, dbo.PRODUCTO.preciounit, dbo.PRODUCTO.preciounit - dbo.PRODUCTO.costo AS utilidad, dbo.PRODUCTO.stock, 
                         dbo.PRODUCTO.fecha_venci, dbo.MARCA.nombre AS Expr1, dbo.CATEGORIA.nombre AS Expr2
FROM            dbo.PRODUCTO INNER JOIN
                         dbo.MARCA ON dbo.PRODUCTO.idmarca = dbo.MARCA.idmarca INNER JOIN
                         dbo.CATEGORIA ON dbo.PRODUCTO.idcategoria = dbo.CATEGORIA.idcategoria
GO
/****** Object:  Table [dbo].[VENTA]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VENTA](
	[numventa] [char](4) NOT NULL,
	[fecha] [date] NOT NULL,
	[idempleado] [int] NOT NULL,
	[idcliente] [int] NOT NULL,
 CONSTRAINT [PK_VENTA] PRIMARY KEY CLUSTERED 
(
	[numventa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DETALLE_VENTA]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DETALLE_VENTA](
	[idventa] [char](4) NOT NULL,
	[idproducto] [int] NOT NULL,
	[cantidad] [int] NOT NULL,
	[precio] [decimal](7, 2) NOT NULL,
 CONSTRAINT [PK_DETALLE_VENTA] PRIMARY KEY CLUSTERED 
(
	[idventa] ASC,
	[idproducto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[V_TICKET]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_TICKET]
AS
SELECT        dbo.DETALLE_VENTA.idventa, dbo.DETALLE_VENTA.cantidad, dbo.DETALLE_VENTA.precio, dbo.PRODUCTO.nombre, dbo.VENTA.fecha
FROM            dbo.DETALLE_VENTA INNER JOIN
                         dbo.VENTA ON dbo.DETALLE_VENTA.idventa = dbo.VENTA.numventa INNER JOIN
                         dbo.PRODUCTO ON dbo.DETALLE_VENTA.idproducto = dbo.PRODUCTO.idproducto
GO
/****** Object:  View [dbo].[V_MANTENIMIENTO_MARCA]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_MANTENIMIENTO_MARCA]
AS
SELECT        idmarca, nombre
FROM            dbo.MARCA
GO
/****** Object:  Table [dbo].[CLIENTE]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CLIENTE](
	[idcliente] [int] IDENTITY(1,1) NOT NULL,
	[dni] [char](8) NOT NULL,
	[nombre] [varchar](150) NOT NULL,
	[telefono] [char](11) NOT NULL,
	[sexo] [char](2) NOT NULL,
	[fecha_naci] [date] NOT NULL,
	[direccion] [varchar](100) NOT NULL,
 CONSTRAINT [PK_CLIENTE] PRIMARY KEY CLUSTERED 
(
	[idcliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[EMPLEADO]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EMPLEADO](
	[idempleado] [int] IDENTITY(1,1) NOT NULL,
	[dni] [char](8) NOT NULL,
	[nombre] [varchar](150) NOT NULL,
	[telefono] [char](11) NOT NULL,
	[sexo] [char](2) NOT NULL,
	[direccion] [varchar](100) NOT NULL,
	[fecha_ingreso] [date] NOT NULL,
	[salario] [decimal](7, 2) NOT NULL,
	[idcargo] [int] NOT NULL,
	[clave] [char](10) NOT NULL,
 CONSTRAINT [PK_EMPLEADO] PRIMARY KEY CLUSTERED 
(
	[idempleado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[V_ENCABEZADO]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_ENCABEZADO]
AS
SELECT        dbo.VENTA.numventa, dbo.VENTA.fecha, dbo.CLIENTE.nombre, dbo.EMPLEADO.nombre AS Expr1
FROM            dbo.VENTA INNER JOIN
                         dbo.CLIENTE ON dbo.VENTA.idcliente = dbo.CLIENTE.idcliente INNER JOIN
                         dbo.EMPLEADO ON dbo.VENTA.idempleado = dbo.EMPLEADO.idempleado
GO
/****** Object:  View [dbo].[V_DIA]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_DIA]
AS
SELECT        SUM(dbo.DETALLE_VENTA.cantidad * dbo.DETALLE_VENTA.precio) AS ventadia, dbo.VENTA.fecha
FROM            dbo.DETALLE_VENTA INNER JOIN
                         dbo.VENTA ON dbo.DETALLE_VENTA.idventa = dbo.VENTA.numventa
GROUP BY dbo.VENTA.fecha
GO
/****** Object:  Table [dbo].[CARGO]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CARGO](
	[idcargo] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
 CONSTRAINT [PK_CARGO] PRIMARY KEY CLUSTERED 
(
	[idcargo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[V_MANTENIMIENTO_CARGO]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_MANTENIMIENTO_CARGO]
AS
SELECT        idcargo, nombre
FROM            dbo.CARGO
GO
/****** Object:  View [dbo].[V_CONSULTA_DETALLE]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_CONSULTA_DETALLE]
AS
SELECT        dbo.DETALLE_VENTA.idventa, dbo.DETALLE_VENTA.cantidad, dbo.PRODUCTO.nombre, dbo.DETALLE_VENTA.precio, dbo.CLIENTE.nombre AS cliente, dbo.VENTA.fecha, 
                         dbo.DETALLE_VENTA.precio * dbo.DETALLE_VENTA.cantidad AS total, dbo.EMPLEADO.nombre AS nombreempleado, dbo.PRODUCTO.costo
FROM            dbo.DETALLE_VENTA INNER JOIN
                         dbo.PRODUCTO ON dbo.DETALLE_VENTA.idproducto = dbo.PRODUCTO.idproducto INNER JOIN
                         dbo.VENTA ON dbo.DETALLE_VENTA.idventa = dbo.VENTA.numventa INNER JOIN
                         dbo.CLIENTE ON dbo.VENTA.idcliente = dbo.CLIENTE.idcliente INNER JOIN
                         dbo.EMPLEADO ON dbo.VENTA.idempleado = dbo.EMPLEADO.idempleado
GO
/****** Object:  View [dbo].[V_DETALLE_VENTA]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_DETALLE_VENTA]
AS
SELECT        dbo.VENTA.numventa, dbo.PRODUCTO.nombre, dbo.DETALLE_VENTA.cantidad, dbo.DETALLE_VENTA.precio, dbo.DETALLE_VENTA.precio * dbo.DETALLE_VENTA.cantidad AS total
FROM            dbo.DETALLE_VENTA INNER JOIN
                         dbo.VENTA ON dbo.DETALLE_VENTA.idventa = dbo.VENTA.numventa INNER JOIN
                         dbo.PRODUCTO ON dbo.DETALLE_VENTA.idproducto = dbo.PRODUCTO.idproducto
GO
/****** Object:  View [dbo].[V_CONSULTA_DETALLEVENTA]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_CONSULTA_DETALLEVENTA]
AS
SELECT        dbo.VENTA.numventa, dbo.DETALLE_VENTA.cantidad, dbo.PRODUCTO.nombre, dbo.DETALLE_VENTA.precio, dbo.CLIENTE.nombre AS cliente, dbo.VENTA.fecha, 
                         dbo.DETALLE_VENTA.precio * dbo.DETALLE_VENTA.cantidad AS total, dbo.EMPLEADO.nombre AS nombreempleado, dbo.PRODUCTO.costo
FROM            dbo.DETALLE_VENTA INNER JOIN
                         dbo.VENTA ON dbo.DETALLE_VENTA.idventa = dbo.VENTA.numventa INNER JOIN
                         dbo.CLIENTE ON dbo.VENTA.idcliente = dbo.CLIENTE.idcliente INNER JOIN
                         dbo.PRODUCTO ON dbo.DETALLE_VENTA.idproducto = dbo.PRODUCTO.idproducto INNER JOIN
                         dbo.EMPLEADO ON dbo.VENTA.idempleado = dbo.EMPLEADO.idempleado
GO
/****** Object:  View [dbo].[V_MANTENIMIENTO_EMPLEADO]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_MANTENIMIENTO_EMPLEADO]
AS
SELECT        dbo.EMPLEADO.idempleado, dbo.EMPLEADO.dni, dbo.EMPLEADO.nombre, dbo.EMPLEADO.telefono, dbo.EMPLEADO.sexo, dbo.EMPLEADO.direccion, dbo.EMPLEADO.fecha_ingreso, dbo.EMPLEADO.salario, 
                         dbo.CARGO.nombre AS cargo, dbo.EMPLEADO.clave
FROM            dbo.EMPLEADO INNER JOIN
                         dbo.CARGO ON dbo.EMPLEADO.idcargo = dbo.CARGO.idcargo
GO
/****** Object:  View [dbo].[V_MANTENIMIENTO_CLIENTE]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_MANTENIMIENTO_CLIENTE]
AS
SELECT        idcliente, dni, nombre, telefono, sexo, fecha_naci, direccion
FROM            dbo.CLIENTE
GO
/****** Object:  View [dbo].[V_MANTENIMIENTO_PRODUCTO]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_MANTENIMIENTO_PRODUCTO]
AS
SELECT        dbo.PRODUCTO.idproducto, dbo.PRODUCTO.nombre, dbo.PRODUCTO.costo, dbo.PRODUCTO.preciounit, dbo.PRODUCTO.stock, dbo.PRODUCTO.fecha_venci, dbo.MARCA.nombre AS marca, 
                         dbo.CATEGORIA.nombre AS categoria
FROM            dbo.PRODUCTO INNER JOIN
                         dbo.MARCA ON dbo.PRODUCTO.idmarca = dbo.MARCA.idmarca INNER JOIN
                         dbo.CATEGORIA ON dbo.PRODUCTO.idcategoria = dbo.CATEGORIA.idcategoria
GO
/****** Object:  View [dbo].[V_GANANCIA]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[V_GANANCIA]
AS
SELECT        SUM((dbo.DETALLE_VENTA.precio - dbo.PRODUCTO.costo) * dbo.DETALLE_VENTA.cantidad) AS utilidad, dbo.VENTA.fecha
FROM            dbo.DETALLE_VENTA INNER JOIN
                         dbo.PRODUCTO ON dbo.DETALLE_VENTA.idproducto = dbo.PRODUCTO.idproducto INNER JOIN
                         dbo.VENTA ON dbo.DETALLE_VENTA.idventa = dbo.VENTA.numventa
GROUP BY dbo.VENTA.fecha
GO
/****** Object:  Table [dbo].[COMPROBANTE]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[COMPROBANTE](
	[idcomprobante] [int] IDENTITY(1,1) NOT NULL,
	[idtipocomprobante] [int] NOT NULL,
	[fecha] [date] NOT NULL,
	[idcliente] [int] NOT NULL,
	[idventa] [int] NOT NULL,
	[total] [decimal](7, 2) NOT NULL,
 CONSTRAINT [PK_COMPROBANTE] PRIMARY KEY CLUSTERED 
(
	[idcomprobante] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PRODUCTOS]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PRODUCTOS](
	[idproducto] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[costo] [decimal](8, 2) NOT NULL,
	[preciounit] [decimal](8, 2) NOT NULL,
	[stock] [int] NOT NULL,
	[marca] [varchar](50) NOT NULL,
	[categoria] [varchar](50) NOT NULL,
 CONSTRAINT [PK_PRODUCTOS] PRIMARY KEY CLUSTERED 
(
	[idproducto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TIPO_COMPROBANTE]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TIPO_COMPROBANTE](
	[idtipocoprobante] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [nchar](10) NOT NULL,
 CONSTRAINT [PK_TIPO_COMPROBANTE] PRIMARY KEY CLUSTERED 
(
	[idtipocoprobante] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[USUARIO]    Script Date: 31-May-21 10:16:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USUARIO](
	[idusuario] [int] IDENTITY(1,1) NOT NULL,
	[dni] [char](10) NOT NULL,
	[nombre] [varchar](100) NOT NULL,
	[telefono] [char](11) NOT NULL,
	[cargo] [varchar](100) NOT NULL,
	[clave] [varchar](50) NOT NULL,
 CONSTRAINT [PK_USUARIO] PRIMARY KEY CLUSTERED 
(
	[idusuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[DETALLE_VENTA]  WITH CHECK ADD  CONSTRAINT [FK_DETALLE_VENTA_PRODUCTO] FOREIGN KEY([idproducto])
REFERENCES [dbo].[PRODUCTO] ([idproducto])
GO
ALTER TABLE [dbo].[DETALLE_VENTA] CHECK CONSTRAINT [FK_DETALLE_VENTA_PRODUCTO]
GO
ALTER TABLE [dbo].[DETALLE_VENTA]  WITH CHECK ADD  CONSTRAINT [FK_DETALLE_VENTA_VENTA1] FOREIGN KEY([idventa])
REFERENCES [dbo].[VENTA] ([numventa])
GO
ALTER TABLE [dbo].[DETALLE_VENTA] CHECK CONSTRAINT [FK_DETALLE_VENTA_VENTA1]
GO
ALTER TABLE [dbo].[EMPLEADO]  WITH CHECK ADD  CONSTRAINT [FK_EMPLEADO_CARGO] FOREIGN KEY([idcargo])
REFERENCES [dbo].[CARGO] ([idcargo])
GO
ALTER TABLE [dbo].[EMPLEADO] CHECK CONSTRAINT [FK_EMPLEADO_CARGO]
GO
ALTER TABLE [dbo].[PRODUCTO]  WITH CHECK ADD  CONSTRAINT [FK_PRODUCTO_CATEGORIA] FOREIGN KEY([idcategoria])
REFERENCES [dbo].[CATEGORIA] ([idcategoria])
GO
ALTER TABLE [dbo].[PRODUCTO] CHECK CONSTRAINT [FK_PRODUCTO_CATEGORIA]
GO
ALTER TABLE [dbo].[PRODUCTO]  WITH CHECK ADD  CONSTRAINT [FK_PRODUCTO_MARCA] FOREIGN KEY([idmarca])
REFERENCES [dbo].[MARCA] ([idmarca])
GO
ALTER TABLE [dbo].[PRODUCTO] CHECK CONSTRAINT [FK_PRODUCTO_MARCA]
GO
ALTER TABLE [dbo].[VENTA]  WITH CHECK ADD  CONSTRAINT [FK_VENTA_CLIENTE] FOREIGN KEY([idcliente])
REFERENCES [dbo].[CLIENTE] ([idcliente])
GO
ALTER TABLE [dbo].[VENTA] CHECK CONSTRAINT [FK_VENTA_CLIENTE]
GO
ALTER TABLE [dbo].[VENTA]  WITH CHECK ADD  CONSTRAINT [FK_VENTA_EMPLEADO] FOREIGN KEY([idempleado])
REFERENCES [dbo].[EMPLEADO] ([idempleado])
GO
ALTER TABLE [dbo].[VENTA] CHECK CONSTRAINT [FK_VENTA_EMPLEADO]
GO
USE [master]
GO
ALTER DATABASE [BDBODEGAPEREZ] SET  READ_WRITE 
GO
