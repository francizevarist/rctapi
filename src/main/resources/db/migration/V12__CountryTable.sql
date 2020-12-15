CREATE TABLE  country (
                          id                    UUID NOT NULL PRIMARY KEY,
                          country_name          VARCHAR(40) NOT NULL,
                          code                  VARCHAR(2) NOT NULL,
                          dial_code             VARCHAR(10) NOT NULL,
                          currency_name         VARCHAR(20) NOT NULL,
                          currency_symbol       CHARACTER(15) NOT NULL,
                          currency_code         VARCHAR(40) NOT NULL
);

INSERT INTO country (id,country_name,code,dial_code,currency_name,currency_symbol,currency_code) VALUES
(gen_random_uuid(), 'Afghanistan', 'AF', '+93', 'Afghan afghani', '؋', 'AFN'),
(gen_random_uuid(), 'Aland Islands', 'AX', '+358', '', '', ''),
(gen_random_uuid(), 'Albania', 'AL', '+355', 'Albanian lek', 'L', 'ALL'),
(gen_random_uuid(), 'Algeria', 'DZ', '+213', 'Algerian dinar', 'د.ج', 'DZD'),
(gen_random_uuid(), 'AmericanSamoa', 'AS', '+1684', '', '', ''),
(gen_random_uuid(), 'Andorra', 'AD', '+376', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Angola', 'AO', '+244', 'Angolan kwanza', 'Kz', 'AOA'),
(gen_random_uuid(), 'Anguilla', 'AI', '+1264', 'East Caribbean dolla', '$', 'XCD'),
(gen_random_uuid(), 'Antarctica', 'AQ', '+672', '', '', ''),
(gen_random_uuid(), 'Antigua and Barbuda', 'AG', '+1268', 'East Caribbean dolla', '$', 'XCD'),
(gen_random_uuid(), 'Argentina', 'AR', '+54', 'Argentine peso', '$', 'ARS'),
(gen_random_uuid(), 'Armenia', 'AM', '+374', 'Armenian dram', '', 'AMD'),
(gen_random_uuid(), 'Aruba', 'AW', '+297', 'Aruban florin', 'ƒ', 'AWG'),
(gen_random_uuid(), 'Australia', 'AU', '+61', 'Australian dollar', '$', 'AUD'),
(gen_random_uuid(), 'Austria', 'AT', '+43', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Azerbaijan', 'AZ', '+994', 'Azerbaijani manat', '', 'AZN'),
(gen_random_uuid(), 'Bahamas', 'BS', '+1242', '', '', ''),
(gen_random_uuid(), 'Bahrain', 'BH', '+973', 'Bahraini dinar', '.د.ب', 'BHD'),
(gen_random_uuid(), 'Bangladesh', 'BD', '+880', 'Bangladeshi taka', '৳', 'BDT'),
(gen_random_uuid(), 'Barbados', 'BB', '+1246', 'Barbadian dollar', '$', 'BBD'),
(gen_random_uuid(), 'Belarus', 'BY', '+375', 'Belarusian ruble', 'Br', 'BYR'),
(gen_random_uuid(), 'Belgium', 'BE', '+32', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Belize', 'BZ', '+501', 'Belize dollar', '$', 'BZD'),
(gen_random_uuid(), 'Benin', 'BJ', '+229', 'West African CFA fra', 'Fr', 'XOF'),
(gen_random_uuid(), 'Bermuda', 'BM', '+1441', 'Bermudian dollar', '$', 'BMD'),
(gen_random_uuid(), 'Bhutan', 'BT', '+975', 'Bhutanese ngultrum', 'Nu.', 'BTN'),
(gen_random_uuid(), 'Bolivia, Plurination', 'BO', '+591', '', '', ''),
(gen_random_uuid(), 'Bosnia and Herzegovi', 'BA', '+387', '', '', ''),
(gen_random_uuid(), 'Botswana', 'BW', '+267', 'Botswana pula', 'P', 'BWP'),
(gen_random_uuid(), 'Brazil', 'BR', '+55', 'Brazilian real', 'R$', 'BRL'),
(gen_random_uuid(), 'British Indian Ocean', 'IO', '+246', '', '', ''),
(gen_random_uuid(), 'Brunei Darussalam', 'BN', '+673', '', '', ''),
(gen_random_uuid(), 'Bulgaria', 'BG', '+359', 'Bulgarian lev', 'лв', 'BGN'),
(gen_random_uuid(), 'Burkina Faso', 'BF', '+226', 'West African CFA fra', 'Fr', 'XOF'),
(gen_random_uuid(), 'Burundi', 'BI', '+257', 'Burundian franc', 'Fr', 'BIF'),
(gen_random_uuid(), 'Cambodia', 'KH', '+855', 'Cambodian riel', '៛', 'KHR'),
(gen_random_uuid(), 'Cameroon', 'CM', '+237', 'Central African CFA ', 'Fr', 'XAF'),
(gen_random_uuid(), 'Canada', 'CA', '+1', 'Canadian dollar', '$', 'CAD'),
(gen_random_uuid(), 'Cape Verde', 'CV', '+238', 'Cape Verdean escudo', 'Esc or $', 'CVE'),
(gen_random_uuid(), 'Cayman Islands', 'KY', '+ 345', 'Cayman Islands dolla', '$', 'KYD'),
(gen_random_uuid(), 'Central African Repu', 'CF', '+236', '', '', ''),
(gen_random_uuid(), 'Chad', 'TD', '+235', 'Central African CFA ', 'Fr', 'XAF'),
(gen_random_uuid(), 'Chile', 'CL', '+56', 'Chilean peso', '$', 'CLP'),
(gen_random_uuid(), 'China', 'CN', '+86', 'Chinese yuan', '¥ or 元', 'CNY'),
(gen_random_uuid(), 'Christmas Island', 'CX', '+61', '', '', ''),
(gen_random_uuid(), 'Cocos (Keeling) Isla', 'CC', '+61', '', '', ''),
(gen_random_uuid(), 'Colombia', 'CO', '+57', 'Colombian peso', '$', 'COP'),
(gen_random_uuid(), 'Comoros', 'KM', '+269', 'Comorian franc', 'Fr', 'KMF'),
(gen_random_uuid(), 'Congo', 'CG', '+242', '', '', ''),
(gen_random_uuid(), 'Congo, The Democrati', 'CD', '+243', '', '', ''),
(gen_random_uuid(), 'Cook Islands', 'CK', '+682', 'New Zealand dollar', '$', 'NZD'),
(gen_random_uuid(), 'Costa Rica', 'CR', '+506', 'Costa Rican colón', '₡', 'CRC'),
(gen_random_uuid(), 'Cote d''Ivoire', 'CI', '+225', 'West African CFA fra', 'Fr', 'XOF'),
(gen_random_uuid(), 'Croatia', 'HR', '+385', 'Croatian kuna', 'kn', 'HRK'),
(gen_random_uuid(), 'Cuba', 'CU', '+53', 'Cuban convertible pe', '$', 'CUC'),
(gen_random_uuid(), 'Cyprus', 'CY', '+357', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Czech Republic', 'CZ', '+420', 'Czech koruna', 'Kč', 'CZK'),
(gen_random_uuid(), 'Denmark', 'DK', '+45', 'Danish krone', 'kr', 'DKK'),
(gen_random_uuid(), 'Djibouti', 'DJ', '+253', 'Djiboutian franc', 'Fr', 'DJF'),
(gen_random_uuid(), 'Dominica', 'DM', '+1767', 'East Caribbean dolla', '$', 'XCD'),
(gen_random_uuid(), 'Dominican Republic', 'DO', '+1849', 'Dominican peso', '$', 'DOP'),
(gen_random_uuid(), 'Ecuador', 'EC', '+593', 'United States dollar', '$', 'USD'),
(gen_random_uuid(), 'Egypt', 'EG', '+20', 'Egyptian pound', '£ or ج.م', 'EGP'),
(gen_random_uuid(), 'El Salvador', 'SV', '+503', 'United States dollar', '$', 'USD'),
(gen_random_uuid(), 'Equatorial Guinea', 'GQ', '+240', 'Central African CFA ', 'Fr', 'XAF'),
(gen_random_uuid(), 'Eritrea', 'ER', '+291', 'Eritrean nakfa', 'Nfk', 'ERN'),
(gen_random_uuid(), 'Estonia', 'EE', '+372', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Ethiopia', 'ET', '+251', 'Ethiopian birr', 'Br', 'ETB'),
(gen_random_uuid(), 'Falkland Islands (Ma', 'FK', '+500', '', '', ''),
(gen_random_uuid(), 'Faroe Islands', 'FO', '+298', 'Danish krone', 'kr', 'DKK'),
(gen_random_uuid(), 'Fiji', 'FJ', '+679', 'Fijian dollar', '$', 'FJD'),
(gen_random_uuid(), 'Finland', 'FI', '+358', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'France', 'FR', '+33', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'French Guiana', 'GF', '+594', '', '', ''),
(gen_random_uuid(), 'French Polynesia', 'PF', '+689', 'CFP franc', 'Fr', 'XPF'),
(gen_random_uuid(), 'Gabon', 'GA', '+241', 'Central African CFA ', 'Fr', 'XAF'),
(gen_random_uuid(), 'Gambia', 'GM', '+220', '', '', ''),
(gen_random_uuid(), 'Georgia', 'GE', '+995', 'Georgian lari', 'ლ', 'GEL'),
(gen_random_uuid(), 'Germany', 'DE', '+49', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Ghana', 'GH', '+233', 'Ghana cedi', '₵', 'GHS'),
(gen_random_uuid(), 'Gibraltar', 'GI', '+350', 'Gibraltar pound', '£', 'GIP'),
(gen_random_uuid(), 'Greece', 'GR', '+30', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Greenland', 'GL', '+299', '', '', ''),
(gen_random_uuid(), 'Grenada', 'GD', '+1473', 'East Caribbean dolla', '$', 'XCD'),
(gen_random_uuid(), 'Guadeloupe', 'GP', '+590', '', '', ''),
(gen_random_uuid(), 'Guam', 'GU', '+1671', '', '', ''),
(gen_random_uuid(), 'Guatemala', 'GT', '+502', 'Guatemalan quetzal', 'Q', 'GTQ'),
(gen_random_uuid(), 'Guernsey', 'GG', '+44', 'British pound', '£', 'GBP'),
(gen_random_uuid(), 'Guinea', 'GN', '+224', 'Guinean franc', 'Fr', 'GNF'),
(gen_random_uuid(), 'Guinea-Bissau', 'GW', '+245', 'West African CFA fra', 'Fr', 'XOF'),
(gen_random_uuid(), 'Guyana', 'GY', '+595', 'Guyanese dollar', '$', 'GYD'),
(gen_random_uuid(), 'Haiti', 'HT', '+509', 'Haitian gourde', 'G', 'HTG'),
(gen_random_uuid(), 'Holy See (Vatican Ci', 'VA', '+379', '', '', ''),
(gen_random_uuid(), 'Honduras', 'HN', '+504', 'Honduran lempira', 'L', 'HNL'),
(gen_random_uuid(), 'Hong Kong', 'HK', '+852', 'Hong Kong dollar', '$', 'HKD'),
(gen_random_uuid(), 'Hungary', 'HU', '+36', 'Hungarian forint', 'Ft', 'HUF'),
(gen_random_uuid(), 'Iceland', 'IS', '+354', 'Icelandic króna', 'kr', 'ISK'),
(gen_random_uuid(), 'India', 'IN', '+91', 'Indian rupee', '₹', 'INR'),
(gen_random_uuid(), 'Indonesia', 'ID', '+62', 'Indonesian rupiah', 'Rp', 'IDR'),
(gen_random_uuid(), 'Iran, Islamic Republ', 'IR', '+98', '', '', ''),
(gen_random_uuid(), 'Iraq', 'IQ', '+964', 'Iraqi dinar', 'ع.د', 'IQD'),
(gen_random_uuid(), 'Ireland', 'IE', '+353', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Isle of Man', 'IM', '+44', 'British pound', '£', 'GBP'),
(gen_random_uuid(), 'Israel', 'IL', '+972', 'Israeli new shekel', '₪', 'ILS'),
(gen_random_uuid(), 'Italy', 'IT', '+39', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Jamaica', 'JM', '+1876', 'Jamaican dollar', '$', 'JMD'),
(gen_random_uuid(), 'Japan', 'JP', '+81', 'Japanese yen', '¥', 'JPY'),
(gen_random_uuid(), 'Jersey', 'JE', '+44', 'British pound', '£', 'GBP'),
(gen_random_uuid(), 'Jordan', 'JO', '+962', 'Jordanian dinar', 'د.ا', 'JOD'),
(gen_random_uuid(), 'Kazakhstan', 'KZ', '+7 7', 'Kazakhstani tenge', '', 'KZT'),
(gen_random_uuid(), 'Kenya', 'KE', '+254', 'Kenyan shilling', 'Sh', 'KES'),
(gen_random_uuid(), 'Kiribati', 'KI', '+686', 'Australian dollar', '$', 'AUD'),
(gen_random_uuid(), 'Korea, Democratic Pe', 'KP', '+850', '', '', ''),
(gen_random_uuid(), 'Korea, Republic of S', 'KR', '+82', '', '', ''),
(gen_random_uuid(), 'Kuwait', 'KW', '+965', 'Kuwaiti dinar', 'د.ك', 'KWD'),
(gen_random_uuid(), 'Kyrgyzstan', 'KG', '+996', 'Kyrgyzstani som', 'лв', 'KGS'),
(gen_random_uuid(), 'Laos', 'LA', '+856', 'Lao kip', '₭', 'LAK'),
(gen_random_uuid(), 'Latvia', 'LV', '+371', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Lebanon', 'LB', '+961', 'Lebanese pound', 'ل.ل', 'LBP'),
(gen_random_uuid(), 'Lesotho', 'LS', '+266', 'Lesotho loti', 'L', 'LSL'),
(gen_random_uuid(), 'Liberia', 'LR', '+231', 'Liberian dollar', '$', 'LRD'),
(gen_random_uuid(), 'Libyan Arab Jamahiri', 'LY', '+218', '', '', ''),
(gen_random_uuid(), 'Liechtenstein', 'LI', '+423', 'Swiss franc', 'Fr', 'CHF'),
(gen_random_uuid(), 'Lithuania', 'LT', '+370', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Luxembourg', 'LU', '+352', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Macao', 'MO', '+853', '', '', ''),
(gen_random_uuid(), 'Macedonia', 'MK', '+389', '', '', ''),
(gen_random_uuid(), 'Madagascar', 'MG', '+261', 'Malagasy ariary', 'Ar', 'MGA'),
(gen_random_uuid(), 'Malawi', 'MW', '+265', 'Malawian kwacha', 'MK', 'MWK'),
(gen_random_uuid(), 'Malaysia', 'MY', '+60', 'Malaysian ringgit', 'RM', 'MYR'),
(gen_random_uuid(), 'Maldives', 'MV', '+960', 'Maldivian rufiyaa', '.ރ', 'MVR'),
(gen_random_uuid(), 'Mali', 'ML', '+223', 'West African CFA fra', 'Fr', 'XOF'),
(gen_random_uuid(), 'Malta', 'MT', '+356', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Marshall Islands', 'MH', '+692', 'United States dollar', '$', 'USD'),
(gen_random_uuid(), 'Martinique', 'MQ', '+596', '', '', ''),
(gen_random_uuid(), 'Mauritania', 'MR', '+222', 'Mauritanian ouguiya', 'UM', 'MRO'),
(gen_random_uuid(), 'Mauritius', 'MU', '+230', 'Mauritian rupee', '₨', 'MUR'),
(gen_random_uuid(), 'Mayotte', 'YT', '+262', '', '', ''),
(gen_random_uuid(), 'Mexico', 'MX', '+52', 'Mexican peso', '$', 'MXN'),
(gen_random_uuid(), 'Micronesia, Federate', 'FM', '+691', '', '', ''),
(gen_random_uuid(), 'Moldova', 'MD', '+373', 'Moldovan leu', 'L', 'MDL'),
(gen_random_uuid(), 'Monaco', 'MC', '+377', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Mongolia', 'MN', '+976', 'Mongolian tögrög', '₮', 'MNT'),
(gen_random_uuid(), 'Montenegro', 'ME', '+382', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Montserrat', 'MS', '+1664', 'East Caribbean dolla', '$', 'XCD'),
(gen_random_uuid(), 'Morocco', 'MA', '+212', 'Moroccan dirham', 'د.م.', 'MAD'),
(gen_random_uuid(), 'Mozambique', 'MZ', '+258', 'Mozambican metical', 'MT', 'MZN'),
(gen_random_uuid(), 'Myanmar', 'MM', '+95', 'Burmese kyat', 'Ks', 'MMK'),
(gen_random_uuid(), 'Namibia', 'NA', '+264', 'Namibian dollar', '$', 'NAD'),
(gen_random_uuid(), 'Nauru', 'NR', '+674', 'Australian dollar', '$', 'AUD'),
(gen_random_uuid(), 'Nepal', 'NP', '+977', 'Nepalese rupee', '₨', 'NPR'),
(gen_random_uuid(), 'Netherlands', 'NL', '+31', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Netherlands Antilles', 'AN', '+599', '', '', ''),
(gen_random_uuid(), 'New Caledonia', 'NC', '+687', 'CFP franc', 'Fr', 'XPF'),
(gen_random_uuid(), 'New Zealand', 'NZ', '+64', 'New Zealand dollar', '$', 'NZD'),
(gen_random_uuid(), 'Nicaragua', 'NI', '+505', 'Nicaraguan córdoba', 'C$', 'NIO'),
(gen_random_uuid(), 'Niger', 'NE', '+227', 'West African CFA fra', 'Fr', 'XOF'),
(gen_random_uuid(), 'Nigeria', 'NG', '+234', 'Nigerian naira', '₦', 'NGN'),
(gen_random_uuid(), 'Niue', 'NU', '+683', 'New Zealand dollar', '$', 'NZD'),
(gen_random_uuid(), 'Norfolk Island', 'NF', '+672', '', '', ''),
(gen_random_uuid(), 'Northern Mariana Isl', 'MP', '+1670', '', '', ''),
(gen_random_uuid(), 'Norway', 'NO', '+47', 'Norwegian krone', 'kr', 'NOK'),
(gen_random_uuid(), 'Oman', 'OM', '+968', 'Omani rial', 'ر.ع.', 'OMR'),
(gen_random_uuid(), 'Pakistan', 'PK', '+92', 'Pakistani rupee', '₨', 'PKR'),
(gen_random_uuid(), 'Palau', 'PW', '+680', 'Palauan dollar', '$', ''),
(gen_random_uuid(), 'Palestinian Territor', 'PS', '+970', '', '', ''),
(gen_random_uuid(), 'Panama', 'PA', '+507', 'Panamanian balboa', 'B/.', 'PAB'),
(gen_random_uuid(), 'Papua New Guinea', 'PG', '+675', 'Papua New Guinean ki', 'K', 'PGK'),
(gen_random_uuid(), 'Paraguay', 'PY', '+595', 'Paraguayan guaraní', '₲', 'PYG'),
(gen_random_uuid(), 'Peru', 'PE', '+51', 'Peruvian nuevo sol', 'S/.', 'PEN'),
(gen_random_uuid(), 'Philippines', 'PH', '+63', 'Philippine peso', '₱', 'PHP'),
(gen_random_uuid(), 'Pitcairn', 'PN', '+872', '', '', ''),
(gen_random_uuid(), 'Poland', 'PL', '+48', 'Polish z?oty', 'zł', 'PLN'),
(gen_random_uuid(), 'Portugal', 'PT', '+351', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Puerto Rico', 'PR', '+1939', '', '', ''),
(gen_random_uuid(), 'Qatar', 'QA', '+974', 'Qatari riyal', 'ر.ق', 'QAR'),
(gen_random_uuid(), 'Romania', 'RO', '+40', 'Romanian leu', 'lei', 'RON'),
(gen_random_uuid(), 'Russia', 'RU', '+7', 'Russian ruble', '', 'RUB'),
(gen_random_uuid(), 'Rwanda', 'RW', '+250', 'Rwandan franc', 'Fr', 'RWF'),
(gen_random_uuid(), 'Reunion', 'RE', '+262', '', '', ''),
(gen_random_uuid(), 'Saint Barthelemy', 'BL', '+590', '', '', ''),
(gen_random_uuid(), 'Saint Helena, Ascens', 'SH', '+290', '', '', ''),
(gen_random_uuid(), 'Saint Kitts and Nevi', 'KN', '+1869', '', '', ''),
(gen_random_uuid(), 'Saint Lucia', 'LC', '+1758', 'East Caribbean dolla', '$', 'XCD'),
(gen_random_uuid(), 'Saint Martin', 'MF', '+590', '', '', ''),
(gen_random_uuid(), 'Saint Pierre and Miq', 'PM', '+508', '', '', ''),
(gen_random_uuid(), 'Saint Vincent and th', 'VC', '+1784', '', '', ''),
(gen_random_uuid(), 'Samoa', 'WS', '+685', 'Samoan t?l?', 'T', 'WST'),
(gen_random_uuid(), 'San Marino', 'SM', '+378', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Sao Tome and Princip', 'ST', '+239', '', '', ''),
(gen_random_uuid(), 'Saudi Arabia', 'SA', '+966', 'Saudi riyal', 'ر.س', 'SAR'),
(gen_random_uuid(), 'Senegal', 'SN', '+221', 'West African CFA fra', 'Fr', 'XOF'),
(gen_random_uuid(), 'Serbia', 'RS', '+381', 'Serbian dinar', 'дин. or din.', 'RSD'),
(gen_random_uuid(), 'Seychelles', 'SC', '+248', 'Seychellois rupee', '₨', 'SCR'),
(gen_random_uuid(), 'Sierra Leone', 'SL', '+232', 'Sierra Leonean leone', 'Le', 'SLL'),
(gen_random_uuid(), 'Singapore', 'SG', '+65', 'Brunei dollar', '$', 'BND'),
(gen_random_uuid(), 'Slovakia', 'SK', '+421', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Slovenia', 'SI', '+386', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Solomon Islands', 'SB', '+677', 'Solomon Islands doll', '$', 'SBD'),
(gen_random_uuid(), 'Somalia', 'SO', '+252', 'Somali shilling', 'Sh', 'SOS'),
(gen_random_uuid(), 'South Africa', 'ZA', '+27', 'South African rand', 'R', 'ZAR'),
(gen_random_uuid(), 'South Georgia and th', 'GS', '+500', '', '', ''),
(gen_random_uuid(), 'Spain', 'ES', '+34', 'Euro', '€', 'EUR'),
(gen_random_uuid(), 'Sri Lanka', 'LK', '+94', 'Sri Lankan rupee', 'Rs or රු', 'LKR'),
(gen_random_uuid(), 'Sudan', 'SD', '+249', 'Sudanese pound', 'ج.س.', 'SDG'),
(gen_random_uuid(), 'Suriname', 'SR', '+597', 'Surinamese dollar', '$', 'SRD'),
(gen_random_uuid(), 'Svalbard and Jan May', 'SJ', '+47', '', '', ''),
(gen_random_uuid(), 'Swaziland', 'SZ', '+268', 'Swazi lilangeni', 'L', 'SZL'),
(gen_random_uuid(), 'Sweden', 'SE', '+46', 'Swedish krona', 'kr', 'SEK'),
(gen_random_uuid(), 'Switzerland', 'CH', '+41', 'Swiss franc', 'Fr', 'CHF'),
(gen_random_uuid(), 'Syrian Arab Republic', 'SY', '+963', '', '', ''),
(gen_random_uuid(), 'Taiwan', 'TW', '+886', 'New Taiwan dollar', '$', 'TWD'),
(gen_random_uuid(), 'Tajikistan', 'TJ', '+992', 'Tajikistani somoni', 'ЅМ', 'TJS'),
(gen_random_uuid(), 'Tanzania, United Rep', 'TZ', '+255', '', '', ''),
(gen_random_uuid(), 'Thailand', 'TH', '+66', 'Thai baht', '฿', 'THB'),
(gen_random_uuid(), 'Timor-Leste', 'TL', '+670', '', '', ''),
(gen_random_uuid(), 'Togo', 'TG', '+228', 'West African CFA fra', 'Fr', 'XOF'),
(gen_random_uuid(), 'Tokelau', 'TK', '+690', '', '', ''),
(gen_random_uuid(), 'Tonga', 'TO', '+676', 'Tongan pa?anga', 'T$', 'TOP'),
(gen_random_uuid(), 'Trinidad and Tobago', 'TT', '+1868', 'Trinidad and Tobago ', '$', 'TTD'),
(gen_random_uuid(), 'Tunisia', 'TN', '+216', 'Tunisian dinar', 'د.ت', 'TND'),
(gen_random_uuid(), 'Turkey', 'TR', '+90', 'Turkish lira', '', 'TRY'),
(gen_random_uuid(), 'Turkmenistan', 'TM', '+993', 'Turkmenistan manat', 'm', 'TMT'),
(gen_random_uuid(), 'Turks and Caicos Isl', 'TC', '+1649', '', '', ''),
(gen_random_uuid(), 'Tuvalu', 'TV', '+688', 'Australian dollar', '$', 'AUD'),
(gen_random_uuid(), 'Uganda', 'UG', '+256', 'Ugandan shilling', 'Sh', 'UGX'),
(gen_random_uuid(), 'Ukraine', 'UA', '+380', 'Ukrainian hryvnia', '₴', 'UAH'),
(gen_random_uuid(), 'United Arab Emirates', 'AE', '+971', 'United Arab Emirates', 'د.إ', 'AED'),
(gen_random_uuid(), 'United Kingdom', 'GB', '+44', 'British pound', '£', 'GBP'),
(gen_random_uuid(), 'United States', 'US', '+1', 'United States dollar', '$', 'USD'),
(gen_random_uuid(), 'Uruguay', 'UY', '+598', 'Uruguayan peso', '$', 'UYU'),
(gen_random_uuid(), 'Uzbekistan', 'UZ', '+998', 'Uzbekistani som', '', 'UZS'),
(gen_random_uuid(), 'Vanuatu', 'VU', '+678', 'Vanuatu vatu', 'Vt', 'VUV'),
(gen_random_uuid(), 'Venezuela, Bolivaria', 'VE', '+58', '', '', ''),
(gen_random_uuid(), 'Vietnam', 'VN', '+84', 'Vietnamese ??ng', '₫', 'VND'),
(gen_random_uuid(), 'Virgin Islands, Brit', 'VG', '+1284', '', '', ''),
(gen_random_uuid(), 'Virgin Islands, U.S.', 'VI', '+1340', '', '', ''),
(gen_random_uuid(), 'Wallis and Futuna', 'WF', '+681', 'CFP franc', 'Fr', 'XPF'),
(gen_random_uuid(), 'Yemen', 'YE', '+967', 'Yemeni rial', '﷼', 'YER'),
(gen_random_uuid(), 'Zambia', 'ZM', '+260', 'Zambian kwacha', 'ZK', 'ZMW'),
(gen_random_uuid(), 'Zimbabwe', 'ZW', '+263', 'Botswana pula', 'P', 'BWP');