-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th6 28, 2020 lúc 08:47 AM
-- Phiên bản máy phục vụ: 10.4.13-MariaDB
-- Phiên bản PHP: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlthi1`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `DiemThi`
--

CREATE TABLE `DiemThi` (
  `id` int(11) NOT NULL,
  `matk` varchar(30) DEFAULT NULL,
  `mon` varchar(20) DEFAULT NULL,
  `diem15` float DEFAULT NULL,
  `diem45` float DEFAULT NULL,
  `diemck` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `DiemThi`
--

INSERT INTO `DiemThi` (`id`, `matk`, `mon`, `diem15`, `diem45`, `diemck`) VALUES
(1, 'HS001', 'Vật lý', 3, 8, 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `DThi`
--

CREATE TABLE `DThi` (
  `id` int(11) NOT NULL,
  `made` varchar(10) DEFAULT NULL,
  `mon` varchar(20) DEFAULT NULL,
  `loaibai` varchar(20) DEFAULT NULL,
  `cauhoi` text DEFAULT NULL,
  `daA` text DEFAULT NULL,
  `daB` text DEFAULT NULL,
  `daC` text DEFAULT NULL,
  `daD` text DEFAULT NULL,
  `daDung` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `DThi`
--

INSERT INTO `DThi` (`id`, `made`, `mon`, `loaibai`, `cauhoi`, `daA`, `daB`, `daC`, `daD`, `daDung`) VALUES
(81, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 1. Hiện tượng quang học nào sau đây sử dụng trong máy phân tích quang phổ lăng kính?', 'A. Hiện tượng phản xạ ánh sáng.	', 'B. Hiện tượng khúc xạ ánh sáng. ', 'C. Hiện tượng tán sắc ánh sáng.	', 'D. Hiện tượng giao thoa ánh sáng.  ', 'D. Hiện tượng giao thoa ánh sáng.  '),
(82, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 2. Trong mạch dao động điện từ LC, nếu điện tích cực đại trên tụ điện là Q0 và cường độ dòng điện cực đại trong mạch là I0 thì chu kì dao động điện từ trong mạch là:', 'A. T = 2 	', 'B. T = 2Q0I0	', 'C. T = 2LC	', 'D. T = 2 ', 'B. T = 2Q0I0	'),
(83, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 3. Khi nói về sóng điện từ, phát biểu nào sau đây là SAI?', 'A. Sóng điện từ tuân theo các quy luật giao thoa, nhiễu xạ', 'B. Sóng điện từ là sóng ngang', 'C. Sóng điện từ mang năng lượng', 'D. Sóng điện từ không truyền được trong chân không ', 'A. Sóng điện từ tuân theo các quy luật giao thoa, nhiễu xạ'),
(84, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 4. Trong thí nghiệm giao thoa ánh sáng bằng khe Young, khoảng cách giữa hai khe sáng a = 2 mm, khoảng cách từ hai khe sáng đến màn D = 1m. Bước sóng ánh sáng dùng trong thí nghiệm  = 0,5µm. Tính khoảng vân:', 'A. 4 mm 	', 'B. 40 mm	', 'C. 2,5 mm 	', 'D. 0,25 mm ', 'C. 2,5 mm'),
(85, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 5. Một mạch dao động LC gồm cuộn cảm thuần có độ tự cảm L =  (H) và một tụ điện có điện dung C =  (F). Chu kì dao động của mạch bằng:', 'A. 0,02(s)	', 'B. 0,2(s)	', 'C. 0,0002(s)	', 'D. 0,002(s)', 'C. 0,0002(s)'),
(86, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 6. . Mạch dao động điện từ gồm cuộn cảm L và tụ điện C, dao động tự do với tần số góc', 'A. = 	', 'B. = 	', 'C. = 	', 'D. =2 ', 'C. = '),
(87, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 7. Quang phổ vạch phát xạ hidro có 4 vạch màu đặc trưng:', 'A.  Đỏ, lam, chàm, tím 	', 'B. Đỏ, vàng, lam, tím. ', 'C. Đỏ, vàng, chàm, tím	', 'D. Đỏ, lục, chàm, tím.', 'A.  Đỏ, lam, chàm, tím'),
(88, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 8. Một mạch LC lí tưởng đang thực hiện dao động điện từ tự do, cường độ tức thời của dòng điện trong mạch là i = 0,05cos(2000t) (A). Cuộn cảm có độ tự cảm L = 0,05H. Điện dung của tụ điện là:', 'A. 5.10-5F	', 'B. 100F	', 'C. 5.10-6F 	', 'D. 0,5F', 'A. 5.10-5F'),
(89, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 9. Phát biểu nào sau đây là SAI khi nói về quang phổ vạch phát xạ?', 'A. Quang phổ vạch phát xạ bao gồm một hệ thống những vạch màu riêng rẽ nằm trên một nền tối.', 'B. Quang phổ vạch phát xạ bao gồm một hệ thống những dãy màu biến thiên liên tục nằm trên một nền tối.', 'C. Mỗi nguyên tố hoá học ở trạng thái khí hay hơi nóng sáng dưới áp suất cho một quang phổ vạch riêng, đặc trưng cho nguyên tố đó.', 'D. Quang phổ vạch phát xạ của các nguyên tố khác nhau thì rất khác nhau về số lượng các vạch quang phổ, vị trí các vạch và độ sáng tỉ đối của các vạch đó.', 'D. Quang phổ vạch phát xạ của các nguyên tố khác nhau thì rất khác nhau về số lượng các vạch quang phổ, vị trí các vạch và độ sáng tỉ đối của các vạch đó.'),
(90, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 10. Một sóng điện từ lan truyền trong chân không có bước sóng là 300m thì tần số của sóng đó là bao nhiêu? Biết c = 3.108m/s.', 'A. 106Hz  	', 'B. 6,5.106Hz 	', 'C. 9.106Hz	', 'D. 4,3.106Hz  ', 'D. 4,3.106Hz  '),
(91, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 11. Khi nói về tia hồng ngoại, phát biểu nào sau đây là SAI?', 'A. Tia hồng ngoại pht ra từ các vậtt bị nung nóng.', 'B. Tia hồng ngoại có tác dụng diệt khuẩn, khử trùng.', 'C. Tia hồng ngoại là bức xạ điện từ có bước sóng lớn hơn bước sóng của ánh sáng đỏ.', 'D. Tia hồng ngoại có tác dụng nhiệt.', 'D. Tia hồng ngoại có tác dụng nhiệt.'),
(92, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 12. Tia hồng ngoại là sóng điện từ có bước sóng:', 'A. 0,4 µm <  < 0,75 µm 	', 'B.  > 0,4 µm', 'C.  < 0,4 µm 	', 'D.  > 0,76 µm ', 'A. 0,4 µm <  < 0,75 µm'),
(93, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 13. Phát biểu nào sau đây là SAI khi nói về ánh sáng đơn sắc?', 'A. Trong cùng một môi trường mỗi ánh sáng đơn sắc có một bước sóng xác định.', 'B. Mỗi ánh sáng đơn sắc có một màu xác định gọi là màu đơn sắc.', 'C. Ánh sáng đơn sắc không bị tán sắc khi truyền qua lăng kính.', 'D. Vận tốc truyền của một ánh sáng đơn sắc trong các môi trường trong suốt khác nhau là như nhau ', 'C. Ánh sáng đơn sắc không bị tán sắc khi truyền qua lăng kính.'),
(94, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 14. Một mạch dao động LC lí tưởng, tụ điện có điện dung C = 0,5 F. Để tần số của dao động của mạch là 960Hz thì độ tự cảm L của cuộn dây là bao nhiêu ?', 'A. 5,49.10-2H 	', 'B.   0,345H	', 'C. 52,8H 	', 'D. 3,3.102H', 'A. 5,49.10-2H'),
(95, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 15. Tia tử ngoại có tính chất nào sau đây?', 'A. Bị lệch trong điện trường và từ trường.	', 'B. Truyền được qua giấy, vải, gỗ..', 'C. Không làm đen kính ảnh. 	', 'D. Kích thích sự phát quang một số chất ', 'B. Truyền được qua giấy, vải, gỗ..'),
(96, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 16. Thực hiện giao thoa với ánh sang đơn sắc, người ta đo được khoảng vân i. Khoảng cách từ vân sáng bậc 3 đến vân sáng bậc 7 nằm về hai phía so với vân trung tâm là', 'A.  x = 10i 	', 'B. x = 11i 	', 'C. x = 9i	', 'D. x = 4i ', 'A.  x = 10i'),
(97, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 17. Một mạch LC lí tưởng đang thực hiện dao động điện từ tự do, tụ điện có điện dung C= 5F, cường độ dòng điện tức thời là  (A). Độ tự cảm của cuộn cảm là:', 'A.  0,05H	', 'B. 0,15H	', 'C. 0,2H	', 'D. 0,25H', 'D. 0,25H'),
(98, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 18. Mạch dao động điện từ lí tưởng gồm cuộn cảm thuần có độ tự cảm L và tụ điện có điện dung C. Trong mạch đang có dao động điện từ tự do. Gọi U0 là hiệu điện thế cực đại giữa hai bản tụ và I0 là cường độ dòng điện cực đại trong mạch. Hệ thức đúng là:', 'A. D	', 'B. E	', 'C. S	', 'D. G', 'D. G'),
(99, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 19. Một mạch dao động điện từ lí tưởng gồm cuộn cảm thuần có độ tự cảm L và tụ điện có điện dung C. Chu kì dao động riêng của mạch là:', 'A. R  	', 'B. d	', 'C. E ', 'C. D	', 'D. E'),
(100, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 20. Trong thí nghiệm Young, khoảng cách 2 khe là 0,5mm, từ 2 khe đến màn giao thoa là 2m. Bước sóng của ánh sáng trong thí nghiệm là 0,4m. Tại điểm cách vân trung tâm 5,6mm là vân gì? Thứ mấy?', 'A. Vân sáng thứ 3. 	', 'B. Vân tối thứ 4	', 'C. Vân tối thứ 3. 	', 'D. Vân sáng thứ 4. ', 'D. Vân sáng thứ 4. '),
(101, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 21. . Mạch dao động bắt tín hiệu của một máy thu vô tuyến điện gồm L = 2 μH và C = 1800pF. Mạch dao động có thể thu được sóng vô tuyến điện với bước sóng bằng:', 'A. 50 m	', 'B. 100 m	', 'C. 113 mm	', 'D. 113 m ', 'C. 113 mm'),
(102, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 22. Sóng điện từ', 'A. không truyền trong chân không	', 'B. không mang năng lượng', 'C. là sóng dọc	', 'D. là sóng ngang', 'A. không truyền trong chân không'),
(103, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 23. Một mạch dao động điện từ lí tưởng gồm cuộn cảm thuần có độ tự cảm L= 2mH và tụ điện có điện dung C= 2pF. Trong mạch đang có dao động điện từ tự do. Lấy 2 = 10. Tần số dao động của mạch :', 'A. 2,5MHz 	', 'B. 2,5Hz	', 'C. 1MHz	', 'D. 1Hz', 'B. 2,5Hz'),
(104, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 24. Trong mạch dao động LC lí tưởng đang có dao động điện từ tự do, điện tích của một bản tụ điện và cường độ dòng điện qua cuộn cảm biến thiên điều hòa theo thời gian', 'A. luôn cùng pha nhau 	', 'B. luôn ngược pha nhau', 'C. với cùng tần số 	', 'D. với cùng biên độ', 'B. luôn ngược pha nhau'),
(105, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 25. Một nguồn sáng S phát ra ánh sáng đơn sắc có bước sóng  = 0,5µm, đến khe Young S1, S2 với S1S2 = a = 0,5mm. Mặt phẳng chứa S1S2 cách màn (E) một khoảng D = 1m. Chiều rộng của vùng giao thoa quan sát được trên màn là L = 13mm. Tìm số vân sáng và vân tối quan sát được.', 'A. 12 sáng, 13 tối 	', 'B. 11 sáng, 12 tối 	', 'C. 13 sáng, 14 tối 	', 'D. 10 sáng, 11 tối', 'A. 12 sáng, 13 tối'),
(106, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 26. Trong thí nghiệm giao thoa ánh sáng với hai khe Young S1 và S2. Một điểm M nằm trên màn cách S1 và S2 những khoảng lần lượt là: MS1 = d1; MS2 = d2. M sẽ ở trên vân sáng khi:', 'A. d2.d1 	', 'B. d2 – d1 = k	', 'C. d2/d1', 'D. d2+d1', 'D. d2+d1'),
(107, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 27. Trong chân không ánh sáng một đơn sắc có bước sóng là λ = 720nm, khi truyền vào nước bước sóng giảm còn λ’= 360nm. Tìm chiết suất của chất lỏng?', 'A. n = 2 	', 'B. n = 1,75	', 'C. n = 1,5 	', 'D. n = 1 ', 'B. n = 1,75'),
(108, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 28. Trong thí nghiệm Young về giao thoa ánh sáng, khoảng cách 2 khe là 0,5mm, từ 2 khe đến màn giao thoa là 2m. Đo bề rộng của 10 vân sáng liên, tiếp được 1,8cm. Suy ra bước sóng của ánh sáng đơn sắc trong thí nghiệm là:', 'A. 0,72µm 	', 'B. 0,8µm	', 'C. 0,45µm. 	', 'D. 0,5µm. ', 'B. 0,8µm'),
(109, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 29. Trong thí nghiệm giao thoa ánh sáng vàng bằng khe Young, khoảng cách giữa hai khe sáng a = 0,3mm, khoảng cách từ hai khe sáng đến màn D = 1m, khoảng vân đo được i = 2mm. Xác định vị trí của vân sáng bậc 5.', 'A. 10 mm 	', 'B. 1 mm 	', 'C. 100 mm	', 'D. 0,1 mm ', 'D. 0,1 mm '),
(110, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 30. Trong mạch dao động LC lí tưởng đang có dao động điện từ tự do. Điện tích cực đại của tụ là  = 1C và dòng điện cực đại qua cuộn dây là  = 10A. Tần số dao động riêng của mạch có giá trị nào?', 'A. 16kHz	', 'B. 1,6kHz 	', 'C. 16MHz 	', 'D. 1,6MHz ', 'C. 16MHz'),
(111, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 31. Trong mạch dao động LC lí tưởng đang có dao động điện từ tự do. Điện tích cực đại của tụ là  = 1C và dòng điện cực đại qua cuộn dây là  = 10A. Tần số dao động riêng của mạch có giá trị nào?', 'A. 16MHz 	', 'B. 16kHz	', 'C. 1,6kHz 	', 'D. 1,6MHz ', 'A. 16MHz'),
(112, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 32. Trong mạch dao động LC lí tưởng đang có dao động điện từ tự do, điện tích của một bản tụ điện và cường độ dòng điện qua cuộn cảm biến thiên điều hòa theo thời gian', 'A. luôn cùng pha nhau 	', 'B. luôn ngược pha nhau', 'C. với cùng tần số 	', 'D. với cùng biên độ', 'B. luôn ngược pha nhau'),
(113, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 33. Một mạch dao động LC gồm cuộn cảm thuần có độ tự cảm L =  (H) và một tụ điện có điện dung C =  (F). Chu kì dao động của mạch bằng:', 'A. 0,002(s)	', 'B. 0,02(s)	', 'C. 0,0002(s)	', 'D. 0,2(s)', 'C. 0,0002(s)'),
(114, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 34. Tia tử ngoại có tính chất nào sau đây?', 'A. Bị lệch trong điện trường và từ trường.	', 'B. Kích thích sự phát quang một số chất ', 'C. Không làm đen kính ảnh. ', 'B. Kích thích sự phát quang một số chất	', 'D. Truyền được qua giấy, vải, gỗ..'),
(115, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 35. Khi nói về sóng điện từ, phát biểu nào sau đây là SAI?', 'A. Sóng điện từ không truyền được trong chân không ', 'B. Sóng điện từ tuân theo các quy luật giao thoa, nhiễu xạ', 'C. Sóng điện từ là sóng ngang', 'D. Sóng điện từ mang năng lượng', 'B. Sóng điện từ tuân theo các quy luật giao thoa, nhiễu xạ'),
(116, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 36. Một mạch LC lí tưởng đang thực hiện dao động điện từ tự do, tụ điện có điện dung C= 5F, cường độ dòng điện tức thời là  (A). Độ tự cảm của cuộn cảm là:', 'A. 0,2H	', 'B. 0,15H	', 'C. 0,05H	', 'D. 0,25H', 'C. 0,05H'),
(117, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 37. Tia hồng ngoại là sóng điện từ có bước sóng:', 'A.  < 0,4 µm 	', 'B.  > 0,76 µm ', 'C.  > 0,4 µm	', 'D. 0,4 µm <  < 0,75 µm ', 'B.  > 0,76 µm '),
(118, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 38. Mạch dao động điện từ lí tưởng gồm cuộn cảm thuần có độ tự cảm L và tụ điện có điện dung C. Trong mạch đang có dao động điện từ tự do. Gọi U0 là hiệu điện thế cực đại giữa hai bản tụ và I0 là cường độ dòng điện cực đại trong mạch. Hệ thức đúng là:', 'A.  < 0,4 µm 	', 'B.  > 0,76 µm ', 'C.  > 0,4 µm	', 'D. 0,4 µm <  < 0,75 µm ', 'B.  > 0,76 µm '),
(119, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 39. Trong thí nghiệm Young, khoảng cách 2 khe là 0,5mm, từ 2 khe đến màn giao thoa là 2m. Bước sóng của ánh sáng trong thí nghiệm là 0,4m. Tại điểm cách vân trung tâm 5,6mm là vân gì? Thứ mấy?', 'A. Vân tối thứ 4	', 'B. Vân sáng thứ 4. 	', 'C. Vân sáng thứ 3. 	', 'D. Vân tối thứ 3. ', 'C. Vân sáng thứ 3.'),
(120, 'DT0', 'Vật lý', 'Cuối kì', 'Câu 40. Trong thí nghiệm giao thoa ánh sáng với hai khe Young S1 và S2. Một điểm M nằm trên màn cách S1 và S2 những khoảng lần lượt là: MS1 = d1; MS2 = d2. M sẽ ở trên vân sáng khi:', 'A. d2.d1 	', 'B. d2 – d1 = k	', 'C. d2/d1', 'D. d2+d1', 'D. d2+d1'),
(141, 'DT40', 'Vật lý', '15 phút', 'Câu 1: Phát biểu nào sau đây là không đúng? Cho các chùm ánh sáng sau: Trắng, đỏ, vàng, tím.', 'Ánh sáng trắng bị tán sắc khi đi qua lăng kính.', 'Chiếu ánh sáng trắng vào máy quang phổ sẽ thu được quang phổ liên tục.', 'Mỗi chùm ánh sáng trên đều có một bước sóng xác định.', 'Ánh sáng tím bị lệch về phía đáy lăng kính nhiều nhất nên chiết suất của lăng kính đối với nó lớn nhất.', 'Mỗi chùm ánh sáng trên đều có một bước sóng xác định.'),
(142, 'DT40', 'Vật lý', '15 phút', 'Câu 2: Trong thí nghiệm Y-âng về giao thoa ánh sáng, hai khe được chiếu bằng ánh sáng đơn sắc λ, màn quan sát cách mặt phẳng hai khe một khoảng không đổi D, khoảng cách giữa hai khe có thể thay đổi (nhưng S1 và S2 luôn cách đều S). Xét điểm M trên màn, lúc đầu là vân sáng bậc 4, nếu lần lượt giảm hoặc tăng khoảng cách S1S2 một lượng Δa thì tại đó là vân sáng bậc k và bậc 3k. Nếu tăng khoảng cách S1S2 thêm 2Δa thì tại M là', 'vân sáng bậc 7. 	   ', 'vân sáng bậc 9. 	        ', 'vân sáng bậc 8. 	         ', 'vân tối thứ 9.', 'vân sáng bậc 8.'),
(143, 'DT40', 'Vật lý', '15 phút', 'Câu 3: Bức xạ có tần số nhỏ nhất trong số các bức xạ: hồng ngoại, tử ngoại, Rơn-ghen, gamma là', 'gama			', 'hồng ngoại.			', 'Rơn-ghen.			', 'tử ngoại.', 'hồng ngoại.'),
(144, 'DT40', 'Vật lý', '15 phút', 'Câu 4: Quang phổ vạch được phát ra khi', 'nung nóng một chất rắn, lỏng hoặc khí                ', 'nung nóng một chất lỏng hoặc chất khí   ', 'nung nóng một chất khí ở áp suất thấp               ', 'nung nóng một chất khí ở điều kiện tiêu chuẩn ', 'nung nóng một chất khí ở áp suất thấp                '),
(145, 'DT40', 'Vật lý', '15 phút', 'Câu 5: Chọn câu trả lời không đúng:', 'Tia X được phát hiện bởi nhà Bác học Rơnghen.                ', 'Tia X có năng lượng lớn vì có bước sóng lớn.', 'Tia  X không bị lệch trong điện trường và trong từ trường.                      ', 'Tia X là sóng điện từ.', 'Tia X có năng lượng lớn vì có bước sóng lớn.'),
(146, 'DT40', 'Vật lý', '15 phút', 'Câu 6: Hạt nhân có độ hụt khối càng lớn thì có', 'năng lượng liên kết càng lớn.	  ', 'năng lượng liên kết riêng càng lớn.', 'năng lượng liên kết càng nhỏ.	                             ', 'năng lượng liên kết riêng càng nhỏ.', 'năng lượng liên kết càng lớn.	'),
(147, 'DT40', 'Vật lý', '15 phút', 'Câu 7: Bản chất lực tương tác giữa các nuclôn trong hạt nhân là ', 'lực tĩnh điện. 		', 'lực hấp dẫn.	   ', 'lực điện từ. 	   	  ', 'lực tương tác mạnh.', 'lực tương tác mạnh.'),
(148, 'DT40', 'Vật lý', '15 phút', 'Câu 8: Quá trình nào sau đây không làm biến đổi hạt nhân', 'phóng xạ                   ', 'phóng xạ                      ', 'phóng xạ  +                      ', 'phóng xạ  -', 'phóng xạ         '),
(149, 'DT40', 'Vật lý', '15 phút', 'Câu 9: Phát biểu nào sau đây là không đúng?', 'Hạt   và hạt   có khối lượng bằng nhau.', 'Hạt   và hạt   được phóng ra từ cùng một đồng vị phóng xạ.', 'Khi đi qua điện trường giữa hai bản tụ hạt   và hạt   bị lệch về hai phía khác nhau.', 'Hạt   và hạt   được phóng ra có tốc độ bằng nhau (gần bằng  tốc độ ánh sáng).', 'Hạt   và hạt   được phóng ra từ cùng một đồng vị phóng xạ.'),
(150, 'DT40', 'Vật lý', '15 phút', 'Câu 10: Linh kiện nào dưới đây hoạt động dựa vào hiện tượng quang điện trong?', 'Tế bào quang điện.             ', 'Pin quang điện.		  ', 'Đèn LED.	         ', 'Nhiệt điện trở.', 'Pin quang điện.');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `GiaoVien`
--

CREATE TABLE `GiaoVien` (
  `matk` varchar(10) NOT NULL,
  `ten` varchar(40) DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `gioitinh` varchar(3) DEFAULT NULL,
  `email` text DEFAULT NULL,
  `sdt` varchar(11) DEFAULT NULL,
  `monday` varchar(20) DEFAULT NULL,
  `diachi` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `GiaoVien`
--

INSERT INTO `GiaoVien` (`matk`, `ten`, `ngaysinh`, `gioitinh`, `email`, `sdt`, `monday`, `diachi`) VALUES
('GV002', 'Hoang Thi Thao', '1988-10-21', 'nữ', 'htthao@gmail.com', '09298779', 'Vật lý', 'Ha Noi'),
('GV003', 'Le Duc Anh', '1977-10-20', 'nam', 'l.ducanh@gmail.com', '098812876', 'Hóa học', 'Ha Noi'),
('GV004', 'Le Thi Thao', '1978-05-12', 'nữ', 'ttthao@gmail.com', '099872983', 'Hóa học', 'Bac Giang');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `HocSinh`
--

CREATE TABLE `HocSinh` (
  `matk` varchar(10) NOT NULL,
  `ten` varchar(40) DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `gioitinh` varchar(3) DEFAULT NULL,
  `email` text DEFAULT NULL,
  `sdt` varchar(11) DEFAULT NULL,
  `lop` varchar(4) DEFAULT NULL,
  `diachi` varchar(50) DEFAULT NULL,
  `khoahoc` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `HocSinh`
--

INSERT INTO `HocSinh` (`matk`, `ten`, `ngaysinh`, `gioitinh`, `email`, `sdt`, `lop`, `diachi`, `khoahoc`) VALUES
('HS001', 'Hoang Dang Khoi', '1999-04-14', 'nam', 'khoidanghoang144@gmail.com', '097876879', '12A1', 'Bac Giang', 2015),
('HS003', 'Dinh The Vinh', '1999-06-11', 'nam', 'dtvinh@gmail.com', '0981972783', '12A2', 'Thai Binh', 2017);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `NHCH`
--

CREATE TABLE `NHCH` (
  `idch` int(11) NOT NULL,
  `mon` varchar(20) DEFAULT NULL,
  `cauhoi` text DEFAULT NULL,
  `daA` text DEFAULT NULL,
  `daB` text DEFAULT NULL,
  `daC` text DEFAULT NULL,
  `daD` text DEFAULT NULL,
  `daDung` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `NHCH`
--

INSERT INTO `NHCH` (`idch`, `mon`, `cauhoi`, `daA`, `daB`, `daC`, `daD`, `daDung`) VALUES
(246, 'Vật lý', 'Câu 1. Hiện tượng quang học nào sau đây sử dụng trong máy phân tích quang phổ lăng kính?', 'A. Hiện tượng phản xạ ánh sáng.	', 'B. Hiện tượng khúc xạ ánh sáng. ', 'C. Hiện tượng tán sắc ánh sáng.	', 'D. Hiện tượng giao thoa ánh sáng.  ', 'D. Hiện tượng giao thoa ánh sáng.  '),
(247, 'Vật lý', 'Câu 2. Trong mạch dao động điện từ LC, nếu điện tích cực đại trên tụ điện là Q0 và cường độ dòng điện cực đại trong mạch là I0 thì chu kì dao động điện từ trong mạch là:', 'A. T = 2 	', 'B. T = 2Q0I0	', 'C. T = 2LC	', 'D. T = 2 ', 'B. T = 2Q0I0	'),
(248, 'Vật lý', 'Câu 3. Khi nói về sóng điện từ, phát biểu nào sau đây là SAI?', 'A. Sóng điện từ tuân theo các quy luật giao thoa, nhiễu xạ', 'B. Sóng điện từ là sóng ngang', 'C. Sóng điện từ mang năng lượng', 'D. Sóng điện từ không truyền được trong chân không ', 'A. Sóng điện từ tuân theo các quy luật giao thoa, nhiễu xạ'),
(249, 'Vật lý', 'Câu 4. Trong thí nghiệm giao thoa ánh sáng bằng khe Young, khoảng cách giữa hai khe sáng a = 2 mm, khoảng cách từ hai khe sáng đến màn D = 1m. Bước sóng ánh sáng dùng trong thí nghiệm  = 0,5µm. Tính khoảng vân:', 'A. 4 mm 	', 'B. 40 mm	', 'C. 2,5 mm 	', 'D. 0,25 mm ', 'C. 2,5 mm'),
(250, 'Vật lý', 'Câu 5. Một mạch dao động LC gồm cuộn cảm thuần có độ tự cảm L =  (H) và một tụ điện có điện dung C =  (F). Chu kì dao động của mạch bằng:', 'A. 0,02(s)	', 'B. 0,2(s)	', 'C. 0,0002(s)	', 'D. 0,002(s)', 'C. 0,0002(s)'),
(251, 'Vật lý', 'Câu 6. . Mạch dao động điện từ gồm cuộn cảm L và tụ điện C, dao động tự do với tần số góc', 'A. = 	', 'B. = 	', 'C. = 	', 'D. =2 ', 'C. = '),
(252, 'Vật lý', 'Câu 7. Quang phổ vạch phát xạ hidro có 4 vạch màu đặc trưng:', 'A.  Đỏ, lam, chàm, tím 	', 'B. Đỏ, vàng, lam, tím. ', 'C. Đỏ, vàng, chàm, tím	', 'D. Đỏ, lục, chàm, tím.', 'A.  Đỏ, lam, chàm, tím'),
(253, 'Vật lý', 'Câu 8. Một mạch LC lí tưởng đang thực hiện dao động điện từ tự do, cường độ tức thời của dòng điện trong mạch là i = 0,05cos(2000t) (A). Cuộn cảm có độ tự cảm L = 0,05H. Điện dung của tụ điện là:', 'A. 5.10-5F	', 'B. 100F	', 'C. 5.10-6F 	', 'D. 0,5F', 'A. 5.10-5F'),
(254, 'Vật lý', 'Câu 9. Phát biểu nào sau đây là SAI khi nói về quang phổ vạch phát xạ?', 'A. Quang phổ vạch phát xạ bao gồm một hệ thống những vạch màu riêng rẽ nằm trên một nền tối.', 'B. Quang phổ vạch phát xạ bao gồm một hệ thống những dãy màu biến thiên liên tục nằm trên một nền tối.', 'C. Mỗi nguyên tố hoá học ở trạng thái khí hay hơi nóng sáng dưới áp suất cho một quang phổ vạch riêng, đặc trưng cho nguyên tố đó.', 'D. Quang phổ vạch phát xạ của các nguyên tố khác nhau thì rất khác nhau về số lượng các vạch quang phổ, vị trí các vạch và độ sáng tỉ đối của các vạch đó.', 'D. Quang phổ vạch phát xạ của các nguyên tố khác nhau thì rất khác nhau về số lượng các vạch quang phổ, vị trí các vạch và độ sáng tỉ đối của các vạch đó.'),
(255, 'Vật lý', 'Câu 10. Một sóng điện từ lan truyền trong chân không có bước sóng là 300m thì tần số của sóng đó là bao nhiêu? Biết c = 3.108m/s.', 'A. 106Hz  	', 'B. 6,5.106Hz 	', 'C. 9.106Hz	', 'D. 4,3.106Hz  ', 'D. 4,3.106Hz  '),
(256, 'Vật lý', 'Câu 11. Khi nói về tia hồng ngoại, phát biểu nào sau đây là SAI?', 'A. Tia hồng ngoại pht ra từ các vậtt bị nung nóng.', 'B. Tia hồng ngoại có tác dụng diệt khuẩn, khử trùng.', 'C. Tia hồng ngoại là bức xạ điện từ có bước sóng lớn hơn bước sóng của ánh sáng đỏ.', 'D. Tia hồng ngoại có tác dụng nhiệt.', 'D. Tia hồng ngoại có tác dụng nhiệt.'),
(257, 'Vật lý', 'Câu 12. Tia hồng ngoại là sóng điện từ có bước sóng:', 'A. 0,4 µm <  < 0,75 µm 	', 'B.  > 0,4 µm', 'C.  < 0,4 µm 	', 'D.  > 0,76 µm ', 'A. 0,4 µm <  < 0,75 µm'),
(258, 'Vật lý', 'Câu 13. Phát biểu nào sau đây là SAI khi nói về ánh sáng đơn sắc?', 'A. Trong cùng một môi trường mỗi ánh sáng đơn sắc có một bước sóng xác định.', 'B. Mỗi ánh sáng đơn sắc có một màu xác định gọi là màu đơn sắc.', 'C. Ánh sáng đơn sắc không bị tán sắc khi truyền qua lăng kính.', 'D. Vận tốc truyền của một ánh sáng đơn sắc trong các môi trường trong suốt khác nhau là như nhau ', 'C. Ánh sáng đơn sắc không bị tán sắc khi truyền qua lăng kính.'),
(259, 'Vật lý', 'Câu 14. Một mạch dao động LC lí tưởng, tụ điện có điện dung C = 0,5 F. Để tần số của dao động của mạch là 960Hz thì độ tự cảm L của cuộn dây là bao nhiêu ?', 'A. 5,49.10-2H 	', 'B.   0,345H	', 'C. 52,8H 	', 'D. 3,3.102H', 'A. 5,49.10-2H'),
(260, 'Vật lý', 'Câu 15. Tia tử ngoại có tính chất nào sau đây?', 'A. Bị lệch trong điện trường và từ trường.	', 'B. Truyền được qua giấy, vải, gỗ..', 'C. Không làm đen kính ảnh. 	', 'D. Kích thích sự phát quang một số chất ', 'B. Truyền được qua giấy, vải, gỗ..'),
(261, 'Vật lý', 'Câu 16. Thực hiện giao thoa với ánh sang đơn sắc, người ta đo được khoảng vân i. Khoảng cách từ vân sáng bậc 3 đến vân sáng bậc 7 nằm về hai phía so với vân trung tâm là', 'A.  x = 10i 	', 'B. x = 11i 	', 'C. x = 9i	', 'D. x = 4i ', 'A.  x = 10i'),
(262, 'Vật lý', 'Câu 17. Một mạch LC lí tưởng đang thực hiện dao động điện từ tự do, tụ điện có điện dung C= 5F, cường độ dòng điện tức thời là  (A). Độ tự cảm của cuộn cảm là:', 'A.  0,05H	', 'B. 0,15H	', 'C. 0,2H	', 'D. 0,25H', 'D. 0,25H'),
(263, 'Vật lý', 'Câu 18. Mạch dao động điện từ lí tưởng gồm cuộn cảm thuần có độ tự cảm L và tụ điện có điện dung C. Trong mạch đang có dao động điện từ tự do. Gọi U0 là hiệu điện thế cực đại giữa hai bản tụ và I0 là cường độ dòng điện cực đại trong mạch. Hệ thức đúng là:', 'A. D	', 'B. E	', 'C. S	', 'D. G', 'D. G'),
(264, 'Vật lý', 'Câu 19. Một mạch dao động điện từ lí tưởng gồm cuộn cảm thuần có độ tự cảm L và tụ điện có điện dung C. Chu kì dao động riêng của mạch là:', 'A. R  	', 'B. d	', 'C. E ', 'C. D	', 'D. E'),
(265, 'Vật lý', 'Câu 20. Trong thí nghiệm Young, khoảng cách 2 khe là 0,5mm, từ 2 khe đến màn giao thoa là 2m. Bước sóng của ánh sáng trong thí nghiệm là 0,4m. Tại điểm cách vân trung tâm 5,6mm là vân gì? Thứ mấy?', 'A. Vân sáng thứ 3. 	', 'B. Vân tối thứ 4	', 'C. Vân tối thứ 3. 	', 'D. Vân sáng thứ 4. ', 'D. Vân sáng thứ 4. '),
(266, 'Vật lý', 'Câu 21. . Mạch dao động bắt tín hiệu của một máy thu vô tuyến điện gồm L = 2 μH và C = 1800pF. Mạch dao động có thể thu được sóng vô tuyến điện với bước sóng bằng:', 'A. 50 m	', 'B. 100 m	', 'C. 113 mm	', 'D. 113 m ', 'C. 113 mm'),
(267, 'Vật lý', 'Câu 22. Sóng điện từ', 'A. không truyền trong chân không	', 'B. không mang năng lượng', 'C. là sóng dọc	', 'D. là sóng ngang', 'A. không truyền trong chân không'),
(268, 'Vật lý', 'Câu 23. Một mạch dao động điện từ lí tưởng gồm cuộn cảm thuần có độ tự cảm L= 2mH và tụ điện có điện dung C= 2pF. Trong mạch đang có dao động điện từ tự do. Lấy 2 = 10. Tần số dao động của mạch :', 'A. 2,5MHz 	', 'B. 2,5Hz	', 'C. 1MHz	', 'D. 1Hz', 'B. 2,5Hz'),
(269, 'Vật lý', 'Câu 24. Trong mạch dao động LC lí tưởng đang có dao động điện từ tự do, điện tích của một bản tụ điện và cường độ dòng điện qua cuộn cảm biến thiên điều hòa theo thời gian', 'A. luôn cùng pha nhau 	', 'B. luôn ngược pha nhau', 'C. với cùng tần số 	', 'D. với cùng biên độ', 'B. luôn ngược pha nhau'),
(270, 'Vật lý', 'Câu 25. Một nguồn sáng S phát ra ánh sáng đơn sắc có bước sóng  = 0,5µm, đến khe Young S1, S2 với S1S2 = a = 0,5mm. Mặt phẳng chứa S1S2 cách màn (E) một khoảng D = 1m. Chiều rộng của vùng giao thoa quan sát được trên màn là L = 13mm. Tìm số vân sáng và vân tối quan sát được.', 'A. 12 sáng, 13 tối 	', 'B. 11 sáng, 12 tối 	', 'C. 13 sáng, 14 tối 	', 'D. 10 sáng, 11 tối', 'A. 12 sáng, 13 tối'),
(271, 'Vật lý', 'Câu 26. Trong thí nghiệm giao thoa ánh sáng với hai khe Young S1 và S2. Một điểm M nằm trên màn cách S1 và S2 những khoảng lần lượt là: MS1 = d1; MS2 = d2. M sẽ ở trên vân sáng khi:', 'A. d2.d1 	', 'B. d2 – d1 = k	', 'C. d2/d1', 'D. d2+d1', 'D. d2+d1'),
(272, 'Vật lý', 'Câu 27. Trong chân không ánh sáng một đơn sắc có bước sóng là λ = 720nm, khi truyền vào nước bước sóng giảm còn λ’= 360nm. Tìm chiết suất của chất lỏng?', 'A. n = 2 	', 'B. n = 1,75	', 'C. n = 1,5 	', 'D. n = 1 ', 'B. n = 1,75'),
(273, 'Vật lý', 'Câu 28. Trong thí nghiệm Young về giao thoa ánh sáng, khoảng cách 2 khe là 0,5mm, từ 2 khe đến màn giao thoa là 2m. Đo bề rộng của 10 vân sáng liên, tiếp được 1,8cm. Suy ra bước sóng của ánh sáng đơn sắc trong thí nghiệm là:', 'A. 0,72µm 	', 'B. 0,8µm	', 'C. 0,45µm. 	', 'D. 0,5µm. ', 'B. 0,8µm'),
(274, 'Vật lý', 'Câu 29. Trong thí nghiệm giao thoa ánh sáng vàng bằng khe Young, khoảng cách giữa hai khe sáng a = 0,3mm, khoảng cách từ hai khe sáng đến màn D = 1m, khoảng vân đo được i = 2mm. Xác định vị trí của vân sáng bậc 5.', 'A. 10 mm 	', 'B. 1 mm 	', 'C. 100 mm	', 'D. 0,1 mm ', 'D. 0,1 mm '),
(275, 'Vật lý', 'Câu 30. Trong mạch dao động LC lí tưởng đang có dao động điện từ tự do. Điện tích cực đại của tụ là  = 1C và dòng điện cực đại qua cuộn dây là  = 10A. Tần số dao động riêng của mạch có giá trị nào?', 'A. 16kHz	', 'B. 1,6kHz 	', 'C. 16MHz 	', 'D. 1,6MHz ', 'C. 16MHz'),
(276, 'Vật lý', 'Câu 31. Trong mạch dao động LC lí tưởng đang có dao động điện từ tự do. Điện tích cực đại của tụ là  = 1C và dòng điện cực đại qua cuộn dây là  = 10A. Tần số dao động riêng của mạch có giá trị nào?', 'A. 16MHz 	', 'B. 16kHz	', 'C. 1,6kHz 	', 'D. 1,6MHz ', 'A. 16MHz'),
(277, 'Vật lý', 'Câu 32. Trong mạch dao động LC lí tưởng đang có dao động điện từ tự do, điện tích của một bản tụ điện và cường độ dòng điện qua cuộn cảm biến thiên điều hòa theo thời gian', 'A. luôn cùng pha nhau 	', 'B. luôn ngược pha nhau', 'C. với cùng tần số 	', 'D. với cùng biên độ', 'B. luôn ngược pha nhau'),
(278, 'Vật lý', 'Câu 33. Một mạch dao động LC gồm cuộn cảm thuần có độ tự cảm L =  (H) và một tụ điện có điện dung C =  (F). Chu kì dao động của mạch bằng:', 'A. 0,002(s)	', 'B. 0,02(s)	', 'C. 0,0002(s)	', 'D. 0,2(s)', 'C. 0,0002(s)'),
(279, 'Vật lý', 'Câu 34. Tia tử ngoại có tính chất nào sau đây?', 'A. Bị lệch trong điện trường và từ trường.	', 'B. Kích thích sự phát quang một số chất ', 'C. Không làm đen kính ảnh. ', 'B. Kích thích sự phát quang một số chất	', 'D. Truyền được qua giấy, vải, gỗ..'),
(280, 'Vật lý', 'Câu 35. Khi nói về sóng điện từ, phát biểu nào sau đây là SAI?', 'A. Sóng điện từ không truyền được trong chân không ', 'B. Sóng điện từ tuân theo các quy luật giao thoa, nhiễu xạ', 'C. Sóng điện từ là sóng ngang', 'D. Sóng điện từ mang năng lượng', 'B. Sóng điện từ tuân theo các quy luật giao thoa, nhiễu xạ'),
(281, 'Vật lý', 'Câu 36. Một mạch LC lí tưởng đang thực hiện dao động điện từ tự do, tụ điện có điện dung C= 5F, cường độ dòng điện tức thời là  (A). Độ tự cảm của cuộn cảm là:', 'A. 0,2H	', 'B. 0,15H	', 'C. 0,05H	', 'D. 0,25H', 'C. 0,05H'),
(282, 'Vật lý', 'Câu 37. Tia hồng ngoại là sóng điện từ có bước sóng:', 'A.  < 0,4 µm 	', 'B.  > 0,76 µm ', 'C.  > 0,4 µm	', 'D. 0,4 µm <  < 0,75 µm ', 'B.  > 0,76 µm '),
(283, 'Vật lý', 'Câu 38. Mạch dao động điện từ lí tưởng gồm cuộn cảm thuần có độ tự cảm L và tụ điện có điện dung C. Trong mạch đang có dao động điện từ tự do. Gọi U0 là hiệu điện thế cực đại giữa hai bản tụ và I0 là cường độ dòng điện cực đại trong mạch. Hệ thức đúng là:', 'A.  < 0,4 µm 	', 'B.  > 0,76 µm ', 'C.  > 0,4 µm	', 'D. 0,4 µm <  < 0,75 µm ', 'B.  > 0,76 µm '),
(284, 'Vật lý', 'Câu 39. Trong thí nghiệm Young, khoảng cách 2 khe là 0,5mm, từ 2 khe đến màn giao thoa là 2m. Bước sóng của ánh sáng trong thí nghiệm là 0,4m. Tại điểm cách vân trung tâm 5,6mm là vân gì? Thứ mấy?', 'A. Vân tối thứ 4	', 'B. Vân sáng thứ 4. 	', 'C. Vân sáng thứ 3. 	', 'D. Vân tối thứ 3. ', 'C. Vân sáng thứ 3.'),
(285, 'Vật lý', 'Câu 40. Trong thí nghiệm giao thoa ánh sáng với hai khe Young S1 và S2. Một điểm M nằm trên màn cách S1 và S2 những khoảng lần lượt là: MS1 = d1; MS2 = d2. M sẽ ở trên vân sáng khi:', 'A. d2.d1 	', 'B. d2 – d1 = k	', 'C. d2/d1', 'D. d2+d1', 'D. d2+d1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `PhanHoi`
--

CREATE TABLE `PhanHoi` (
  `id` int(11) NOT NULL,
  `mang` varchar(10) DEFAULT NULL,
  `mann` varchar(10) DEFAULT NULL,
  `nd` text DEFAULT NULL,
  `tt` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `PhanHoi`
--

INSERT INTO `PhanHoi` (`id`, `mang`, `mann`, `nd`, `tt`) VALUES
(1, 'HS001', 'GV002', 'E chao co a', 2),
(2, 'GV002', 'HS001', 'Co chao em', 2),
(3, 'HS001', 'GV002', 'Co cho e hoi con bai kieam tra 15p nao nua khong a', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `PhongThi`
--

CREATE TABLE `PhongThi` (
  `maphong` varchar(10) NOT NULL,
  `mon` varchar(20) DEFAULT NULL,
  `lop` varchar(4) DEFAULT NULL,
  `thoigianthi` date DEFAULT NULL,
  `thoiluongthi` int(11) DEFAULT NULL,
  `giobatdau` time DEFAULT NULL,
  `made` varchar(7) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `PhongThi`
--

INSERT INTO `PhongThi` (`maphong`, `mon`, `lop`, `thoigianthi`, `thoiluongthi`, `giobatdau`, `made`) VALUES
('Mp003', 'Vật lý', '12A2', '2020-07-20', 20, '09:00:00', 'DT0'),
('MV001', 'Vật lý', '12A1', '2020-08-10', 10, '09:00:00', 'DT40');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `TaiKhoan`
--

CREATE TABLE `TaiKhoan` (
  `id` int(11) NOT NULL,
  `matk` varchar(10) DEFAULT NULL,
  `matkhau` varchar(20) DEFAULT NULL,
  `quyen` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `TaiKhoan`
--

INSERT INTO `TaiKhoan` (`id`, `matk`, `matkhau`, `quyen`) VALUES
(1, 'admin', 'admin', 1),
(4, 'GV002', '1111', 2),
(7, 'HS001', '1234', 3),
(8, 'HS002', '1111', 3),
(9, 'GV003', '1234', 2),
(10, 'GV004', '1234', 2),
(11, 'HS003', '1234', 3);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `DiemThi`
--
ALTER TABLE `DiemThi`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `DThi`
--
ALTER TABLE `DThi`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `GiaoVien`
--
ALTER TABLE `GiaoVien`
  ADD PRIMARY KEY (`matk`);

--
-- Chỉ mục cho bảng `HocSinh`
--
ALTER TABLE `HocSinh`
  ADD PRIMARY KEY (`matk`);

--
-- Chỉ mục cho bảng `NHCH`
--
ALTER TABLE `NHCH`
  ADD PRIMARY KEY (`idch`);

--
-- Chỉ mục cho bảng `PhanHoi`
--
ALTER TABLE `PhanHoi`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `PhongThi`
--
ALTER TABLE `PhongThi`
  ADD PRIMARY KEY (`maphong`);

--
-- Chỉ mục cho bảng `TaiKhoan`
--
ALTER TABLE `TaiKhoan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `DiemThi`
--
ALTER TABLE `DiemThi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `DThi`
--
ALTER TABLE `DThi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=151;

--
-- AUTO_INCREMENT cho bảng `NHCH`
--
ALTER TABLE `NHCH`
  MODIFY `idch` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=286;

--
-- AUTO_INCREMENT cho bảng `PhanHoi`
--
ALTER TABLE `PhanHoi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `TaiKhoan`
--
ALTER TABLE `TaiKhoan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
