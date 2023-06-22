-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 22/06/2023 às 19:50
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `carteiracentral`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `cartaodecredito`
--

CREATE TABLE `cartaodecredito` (
  `idCartaoDeCredito` int(11) NOT NULL,
  `NomeCartao` varchar(45) NOT NULL,
  `LimiteCartao` double NOT NULL,
  `DataFechamento` int(11) NOT NULL,
  `DataVencimento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;

--
-- Despejando dados para a tabela `cartaodecredito`
--

INSERT INTO `cartaodecredito` (`idCartaoDeCredito`, `NomeCartao`, `LimiteCartao`, `DataFechamento`, `DataVencimento`) VALUES
(1, 'Nubank', 5000, 1, 11);

-- --------------------------------------------------------

--
-- Estrutura para tabela `categoria`
--

CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL,
  `NomeCategoria` varchar(45) NOT NULL,
  `TipoLancamento` enum('Despesa','Receita','Transferencia') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;

--
-- Despejando dados para a tabela `categoria`
--

INSERT INTO `categoria` (`idCategoria`, `NomeCategoria`, `TipoLancamento`) VALUES
(2, 'Salario', 'Receita'),
(4, 'Outros', 'Receita'),
(6, 'Recebido', 'Transferencia'),
(8, 'Alimentaçäo', 'Despesa'),
(9, 'Lazer', 'Despesa'),
(11, 'Teste', 'Despesa');

-- --------------------------------------------------------

--
-- Estrutura para tabela `conta`
--

CREATE TABLE `conta` (
  `idConta` int(11) NOT NULL,
  `NomeConta` varchar(100) NOT NULL,
  `SaldoConta` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `conta`
--

INSERT INTO `conta` (`idConta`, `NomeConta`, `SaldoConta`) VALUES
(0, 'Conta inicial', 0),
(1, 'Nubank', 2200),
(2, 'Banco do Brasil', 450);

-- --------------------------------------------------------

--
-- Estrutura para tabela `movimentacao`
--

CREATE TABLE `movimentacao` (
  `idMovimentacao` int(11) NOT NULL,
  `idContaOrigem` int(11) DEFAULT NULL,
  `idContaDestino` int(11) DEFAULT NULL,
  `tipoMovi` enum('Despesa','Receita','Transferencia') NOT NULL,
  `idCategoria` int(11) DEFAULT NULL,
  `valorMovi` double NOT NULL,
  `dataMovi` date NOT NULL,
  `descricaoMovi` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `movimentacao`
--

INSERT INTO `movimentacao` (`idMovimentacao`, `idContaOrigem`, `idContaDestino`, `tipoMovi`, `idCategoria`, `valorMovi`, `dataMovi`, `descricaoMovi`) VALUES
(70, 0, 1, 'Transferencia', 6, 1000, '2023-06-01', 'g'),
(71, 1, 0, 'Transferencia', 6, 100, '2023-06-22', 'a'),
(72, 1, 0, 'Transferencia', 6, 200, '2023-06-07', 'a'),
(73, 0, 1, 'Transferencia', 6, 100, '2023-06-15', '1000'),
(74, 0, 1, 'Transferencia', 6, 300, '2023-06-14', 'q'),
(75, 1, 0, 'Transferencia', 6, 400, '2023-06-30', 's'),
(76, 1, 0, 'Transferencia', 6, 400, '2023-07-01', 's'),
(77, 1, 0, 'Transferencia', 6, 400, '2023-06-30', ''),
(78, NULL, 0, 'Despesa', 8, -2000, '2023-06-16', 'aa'),
(79, 1, 0, 'Transferencia', 6, 100, '2023-06-15', '100'),
(80, 0, 1, 'Transferencia', 6, -100, '2023-06-15', '100'),
(81, 1, 0, 'Transferencia', 6, -200, '2023-06-22', ''),
(82, 0, 1, 'Transferencia', 6, 200, '2023-06-22', ''),
(83, 1, 0, 'Transferencia', 6, -100, '2023-06-30', ''),
(84, 0, 1, 'Transferencia', 6, 100, '2023-06-30', ''),
(85, 0, 1, 'Transferencia', 6, 100, '2023-06-20', ''),
(86, 1, 0, 'Transferencia', 6, -100, '2023-06-20', ''),
(87, 0, 1, 'Transferencia', 6, 100, '2023-06-15', ''),
(88, 1, 0, 'Transferencia', 6, -100, '2023-06-15', ''),
(89, 0, 1, 'Transferencia', 6, 100, '2023-06-30', ''),
(90, 1, 0, 'Transferencia', 6, -100, '2023-06-30', ''),
(91, 1, 0, 'Transferencia', 6, -100, '2023-06-30', ''),
(92, 0, 1, 'Transferencia', 6, 100, '2023-06-30', ''),
(93, 0, 1, 'Transferencia', 6, 100, '2023-06-29', ''),
(94, 1, 0, 'Transferencia', 6, -100, '2023-06-29', ''),
(95, 1, 0, 'Transferencia', 6, -100, '2023-06-30', ''),
(96, 0, 1, 'Transferencia', 6, 100, '2023-06-30', ''),
(97, 1, 0, 'Transferencia', 6, -100, '2023-06-23', ''),
(98, 1, 0, 'Transferencia', 6, 100, '2023-06-23', ''),
(99, 1, 0, 'Transferencia', 6, -100, '2023-06-30', ''),
(100, 0, 1, 'Transferencia', 6, 100, '2023-06-30', ''),
(101, 0, 1, 'Transferencia', 6, -100, '2023-06-23', ''),
(102, 1, 0, 'Transferencia', 6, 100, '2023-06-23', ''),
(103, 1, 0, 'Transferencia', 6, -200, '2023-06-30', ''),
(104, 0, 1, 'Transferencia', 6, 200, '2023-06-30', ''),
(105, 0, 1, 'Transferencia', 6, -200, '2023-06-22', ''),
(106, 1, 0, 'Transferencia', 6, 200, '2023-06-22', ''),
(107, 1, 0, 'Transferencia', 6, 200, '2023-06-30', ''),
(108, 0, 1, 'Transferencia', 6, -200, '2023-06-30', ''),
(109, NULL, 1, 'Despesa', 8, -200, '2023-06-14', 'Teste'),
(110, NULL, 0, 'Receita', 2, 1100, '2023-06-23', 'teste'),
(111, 1, 0, 'Transferencia', 6, 800, '2023-06-23', ''),
(112, 0, 1, 'Transferencia', 6, -800, '2023-06-23', ''),
(113, 0, 1, 'Transferencia', 6, 900, '2023-06-30', ''),
(114, 1, 0, 'Transferencia', 6, -900, '2023-06-30', ''),
(115, 0, 1, 'Transferencia', 6, 100, '2023-06-15', ''),
(116, 1, 0, 'Transferencia', 6, -100, '2023-06-15', ''),
(117, 1, 0, 'Transferencia', 6, 200, '2023-06-23', ''),
(118, 0, 1, 'Transferencia', 6, -200, '2023-06-23', ''),
(119, NULL, 1, 'Despesa', 8, -200, '2023-06-22', 'Teste'),
(120, NULL, 0, 'Despesa', 8, -200, '2023-05-01', 'Teste'),
(121, NULL, 0, 'Receita', 2, 200, '2023-06-22', 'teste'),
(122, 1, 0, 'Transferencia', 6, 600, '2023-06-16', ''),
(123, 0, 1, 'Transferencia', 6, -600, '2023-06-16', ''),
(124, NULL, 2, 'Despesa', 8, -250, '2023-06-18', 'Mercado'),
(125, NULL, 2, 'Despesa', 9, -100, '2023-06-16', 'Teste'),
(126, NULL, 2, 'Despesa', 9, -200, '2023-05-02', 'TEste'),
(127, NULL, 2, 'Receita', 2, 1000, '2023-06-14', 'Teste'),
(128, 0, 1, 'Transferencia', 6, 600, '2023-06-22', 'caixinha'),
(129, 0, 1, 'Transferencia', 6, 600, '2023-06-23', 'a'),
(130, 1, 0, 'Transferencia', 6, -600, '2023-06-23', 'a');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `cartaodecredito`
--
ALTER TABLE `cartaodecredito`
  ADD PRIMARY KEY (`idCartaoDeCredito`),
  ADD UNIQUE KEY `idCartaoDeCredito_UNIQUE` (`idCartaoDeCredito`);

--
-- Índices de tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Índices de tabela `conta`
--
ALTER TABLE `conta`
  ADD PRIMARY KEY (`idConta`);

--
-- Índices de tabela `movimentacao`
--
ALTER TABLE `movimentacao`
  ADD PRIMARY KEY (`idMovimentacao`),
  ADD KEY `idConta_idx` (`idContaOrigem`),
  ADD KEY `idCategoria_idx` (`idCategoria`),
  ADD KEY `idContaDestino_idx` (`idContaDestino`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cartaodecredito`
--
ALTER TABLE `cartaodecredito`
  MODIFY `idCartaoDeCredito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de tabela `conta`
--
ALTER TABLE `conta`
  MODIFY `idConta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `movimentacao`
--
ALTER TABLE `movimentacao`
  MODIFY `idMovimentacao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=131;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `movimentacao`
--
ALTER TABLE `movimentacao`
  ADD CONSTRAINT `idCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `idContaDestino` FOREIGN KEY (`idContaDestino`) REFERENCES `conta` (`idConta`),
  ADD CONSTRAINT `idContaOrigem` FOREIGN KEY (`idContaOrigem`) REFERENCES `conta` (`idConta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
