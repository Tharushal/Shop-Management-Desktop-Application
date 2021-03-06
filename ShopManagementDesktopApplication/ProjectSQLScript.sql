USE [JavaProject]
GO
/****** Object:  StoredProcedure [dbo].[User_Insert]    Script Date: 1/8/2019 2:12:04 PM ******/
DROP PROCEDURE [dbo].[User_Insert]
GO
/****** Object:  StoredProcedure [dbo].[OInfo]    Script Date: 1/8/2019 2:12:04 PM ******/
DROP PROCEDURE [dbo].[OInfo]
GO
/****** Object:  Table [dbo].[User_Account]    Script Date: 1/8/2019 2:12:04 PM ******/
DROP TABLE [dbo].[User_Account]
GO
/****** Object:  Table [dbo].[Tempery]    Script Date: 1/8/2019 2:12:04 PM ******/
DROP TABLE [dbo].[Tempery]
GO
/****** Object:  Table [dbo].[Supplier]    Script Date: 1/8/2019 2:12:04 PM ******/
DROP TABLE [dbo].[Supplier]
GO
/****** Object:  Table [dbo].[OrderInfo]    Script Date: 1/8/2019 2:12:04 PM ******/
DROP TABLE [dbo].[OrderInfo]
GO
/****** Object:  Table [dbo].[Item]    Script Date: 1/8/2019 2:12:04 PM ******/
DROP TABLE [dbo].[Item]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 1/8/2019 2:12:04 PM ******/
DROP TABLE [dbo].[Category]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 1/8/2019 2:12:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[CId] [int] NOT NULL,
	[C_Name] [varchar](50) NULL,
	[C_Date] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[CId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Item]    Script Date: 1/8/2019 2:12:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Item](
	[Iid] [int] IDENTITY(10,4) NOT NULL,
	[Category] [varchar](30) NOT NULL,
	[I_name] [varchar](50) NULL,
	[I_Date] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[Category] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderInfo]    Script Date: 1/8/2019 2:12:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderInfo](
	[PId] [int] NOT NULL,
	[Category] [varchar](50) NULL,
	[Item] [varchar](50) NULL,
	[U_Price] [money] NULL,
	[Quan] [int] NULL,
	[Amount] [money] NULL,
	[S_Id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[PId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Supplier]    Script Date: 1/8/2019 2:12:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Supplier](
	[NIC] [char](10) NOT NULL,
	[Sname] [varchar](50) NULL,
	[Email] [varchar](50) NULL,
	[Phone_Num] [char](15) NULL,
	[S_Date] [date] NULL,
	[S_Address] [varchar](70) NULL,
PRIMARY KEY CLUSTERED 
(
	[NIC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tempery]    Script Date: 1/8/2019 2:12:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tempery](
	[Id] [int] NULL,
	[Category] [varchar](40) NULL,
	[Item] [varchar](40) NULL,
	[Sal] [money] NULL,
	[Quan] [int] NULL,
	[Salary] [money] NULL,
	[Idd] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User_Account]    Script Date: 1/8/2019 2:12:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User_Account](
	[U_Id] [int] NOT NULL,
	[Uname] [varchar](50) NULL,
	[U_Password] [varchar](50) NULL,
	[Email] [varchar](70) NULL,
	[U_Type] [varchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[U_Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Category] ([CId], [C_Name], [C_Date]) VALUES (45, N'wwww', CAST(N'1111-12-12' AS Date))
INSERT [dbo].[Category] ([CId], [C_Name], [C_Date]) VALUES (345, N'OOP', CAST(N'2013-09-12' AS Date))
INSERT [dbo].[Category] ([CId], [C_Name], [C_Date]) VALUES (453, N'EER', CAST(N'2012-09-23' AS Date))
SET IDENTITY_INSERT [dbo].[Item] ON 

INSERT [dbo].[Item] ([Iid], [Category], [I_name], [I_Date]) VALUES (10, N'Kelly', N'wwe', CAST(N'4569-08-12' AS Date))
INSERT [dbo].[Item] ([Iid], [Category], [I_name], [I_Date]) VALUES (14, N'qqw', N'kb', CAST(N'2024-02-12' AS Date))
SET IDENTITY_INSERT [dbo].[Item] OFF
INSERT [dbo].[OrderInfo] ([PId], [Category], [Item], [U_Price], [Quan], [Amount], [S_Id]) VALUES (100006, N'Mia', N'Melano', 4000.0000, 2, 8000.0000, 100)
INSERT [dbo].[OrderInfo] ([PId], [Category], [Item], [U_Price], [Quan], [Amount], [S_Id]) VALUES (100013, N'Benz', N'YOU', 20.0000, 5, 100.0000, 100)
INSERT [dbo].[OrderInfo] ([PId], [Category], [Item], [U_Price], [Quan], [Amount], [S_Id]) VALUES (100020, N'qqw', N'iiop', 23.0000, 2, 46.0000, 100)
INSERT [dbo].[OrderInfo] ([PId], [Category], [Item], [U_Price], [Quan], [Amount], [S_Id]) VALUES (100027, N'yyu', N'iii', 22.0000, 2, 44.0000, 100)
INSERT [dbo].[OrderInfo] ([PId], [Category], [Item], [U_Price], [Quan], [Amount], [S_Id]) VALUES (100034, N'qqw', N'iio', 23.0000, 5, 115.0000, 100)
INSERT [dbo].[OrderInfo] ([PId], [Category], [Item], [U_Price], [Quan], [Amount], [S_Id]) VALUES (100041, N'wwerrreeed', N'tty', 23.0000, 6, 138.0000, 100)
INSERT [dbo].[Supplier] ([NIC], [Sname], [Email], [Phone_Num], [S_Date], [S_Address]) VALUES (N'112       ', N'ssd', N'ccv', N'34234          ', CAST(N'0056-09-23' AS Date), N'errer')
INSERT [dbo].[Supplier] ([NIC], [Sname], [Email], [Phone_Num], [S_Date], [S_Address]) VALUES (N'wwee      ', N'cdc', N'ddd', N'erw            ', CAST(N'1089-10-02' AS Date), N'tygf')
INSERT [dbo].[Tempery] ([Id], [Category], [Item], [Sal], [Quan], [Salary], [Idd]) VALUES (100, N'wwe', N'tty', 45.6000, 2, 32.3400, 12)
INSERT [dbo].[User_Account] ([U_Id], [Uname], [U_Password], [Email], [U_Type]) VALUES (1003, N'aas', N'aas', N'sunny@gmail.com', N'Normal')
/****** Object:  StoredProcedure [dbo].[OInfo]    Script Date: 1/8/2019 2:12:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Procedure [dbo].[OInfo](@PId int out,@Category varchar(50),@Item varchar(50),@U_Price money,@Quan int,@Amount money,@SId int)
AS
Begin
Select @PId = IsNull(Max(PId),99999)+7  from OrderInfo
Insert into OrderInfo(PId,Category,Item,U_Price,Quan,Amount,S_Id) Values (@PId,@Category,@Item,@U_Price,@Quan,@Amount,@SId);
End
GO
/****** Object:  StoredProcedure [dbo].[User_Insert]    Script Date: 1/8/2019 2:12:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create Procedure [dbo].[User_Insert](@U_Id int,@Uname varchar(50),@U_Password varchar(40),@Email varchar(50),@U_Type varchar(40))
As
Begin
  Select @U_Id =IsNull(Max(U_Id),999)+2 from User_Account;  
  Insert Into User_Account (U_Id,Uname,U_Password,Email,U_Type) Values (@U_Id,@Uname,@U_Password,@Email,@U_Type)
End;
GO
