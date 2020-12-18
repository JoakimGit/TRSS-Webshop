INSERT INTO product (product_id, name, description, price, category) VALUES (1, 'Wi-Fi kamera - Auto Tracking', 'Trådløst Wi-Fi IP kamera, til indendørs overvågning i Fuld HD kvalitet. Auto Tracking - Kameraet kan dreje/følge efter bevægelser. Optag i skyen eller på SD-kort, og se alle optagelser via appen.', 799.00, 'Overvågningskamera');
INSERT INTO product (product_id, name, description, price, category) VALUES (2, 'Overvågningskamera - HD Wi-Fi IP', 'Plug-n-Play Wi-Fi trådløst IP kamera, til indendørs og udendørs overvågning i fuld HD-kvalitet. Plads til micro SD-kort op til 128GB. Så kameraet kan gemme optagelser ved bevægelse eller konstant, og som kan ses og downloades via app eller browser.', 949.00, 'Overvågningskamera');
INSERT INTO product (product_id, name, description, price, category) VALUES (3, 'Overvågningskamera - 4G Wi-Fi IP', 'Robust PTZ Speed Dome trådløst 4G IP kamera, til udendørs overvågning, med motoriseret fjernstyringsfunktion og zoom (PTZ) i Fuld HD+ kvalitet. Lille PTZ kamera: 160mm x 100mm x 175mm (LxBxH). Kameraet har plads til 4G SIM-kort, så det har direkte kontakt til internettet. SIM-kort medfølger ikke. Plads til micro SD-kort op til 128GB. Så kameraet kan gemme optagelser ved bevægelse eller konstant, og som kan ses og downloades via app eller browser.', 5499.00, 'Overvågningskamera');
INSERT INTO product (product_id, name, description, price, category) VALUES (4, 'Overvågningskamera - 4MP PTZ Udendørs IP 20X zoom', 'Speed Dome IP kamera, med 20x zoom i høj 4MP videokvalitet, motoriseret fjernstyringsfunktion, til udendørs overvågning. Vi anbefaler, at købe dette kamera til brug med en NVR harddiskoptager.', 3999.00, 'Overvågningskamera');
INSERT INTO product (product_id, name, description, price, category) VALUES (5, 'Overvågningskamera - 5MP Wi-Fi IP', 'Trådløst Wi-Fi IP kamera, til indendørs og udendørs overvågning i fuld HD+ 1960p videokvalitet. Plads til micro SD-kort op til 128GB. Så kameraet kan gemme optagelser ved bevægelse eller konstant, og som kan ses og downloades via app eller browser.', 1549.00, 'Overvågningskamera');
INSERT INTO product (product_id, name, description, price, category) VALUES (6, 'Overvågningspakke - Wi-Fi IP', 'Trådløst Wi-Fi IP kamera, til udendørs overvågning i Fuld HD-kvalitet, fra Camwon.', 4449.00, 'Overvågningspakke');
INSERT INTO product (product_id, name, description, price, category) VALUES (7, 'Overvågningspakke plus - Wi-Fi IP', 'Speed Dome trådløst Wi-Fi IP kamera, til udendørs overvågning, med motoriseret fjernstyringsfunktion og zoom (PTZ) i Fuld HD+ kvalitet. Auto Tracking - Kameraet kan automatisk følge bevægelser. Lille PTZ kamera: 160mm x 100mm x 175mm (LxBxH).', 9129.00, 'Overvågningspakke');
INSERT INTO product (product_id, name, description, price, category) VALUES (8, 'SMART SAFE 1', 'Panelet kan eksempelvis blive tilkoblet fjernbetjeninger, magnetkontakter, rumfølere, sirener og keypad fra Smart-safe. Den har mange smarte funktioner og kan bruges sammen med alt tilbehøret fra Smart-safe såsom fjernbetjeninger, magnetkontakter, sirener, røgalarmer, PIR-sensorer mm. Alarmen er kompatibel med tidligere solgte alarmer fra GSM Teknik såsom Luxus, Elegant, Deluxe og WiFi Deluxe.', 699.00, 'Alarm Panel');
INSERT INTO product (product_id, name, description, price, category) VALUES (9, 'SMART SAFE 2', 'Smart Safe 2 er et Alarmsæt, som  giver dig mulighed for at styre sikkerheden i dit hjem, selv når du er på farten. Ved hjælp af den tilhørende app, kan du tilgå feedet fra kameraet, og derved holde øje med dit hjem. Denne pakke indeholder alt du skal bruge for at højne sikkerheden i dit hjem. Det kan tilgå WiFi.', 2999.00, 'Alarm Panel');

INSERT INTO inventory VALUES (1, 23, 'På lager');
INSERT INTO inventory VALUES (2, 17, 'På lager');
INSERT INTO inventory VALUES (3, 29, 'På lager');
INSERT INTO inventory VALUES (4, 25, 'På lager');
INSERT INTO inventory VALUES (5, 13, 'På lager');
INSERT INTO inventory VALUES (6, 28, 'På lager');
INSERT INTO inventory VALUES (7, 22, 'På lager');
INSERT INTO inventory VALUES (8, 12, 'På lager');
INSERT INTO inventory VALUES (9, 18, 'På lager');

INSERT INTO customer (customer_id, first_name, last_name, username, address, email, phone_number) VALUES (1, 'Hans', 'Hansen', 'HHans', 'Hvidovrevej 13', 'HHansen@gmail.com', '82305812');
INSERT INTO customer (customer_id, first_name, last_name, username, address, email, phone_number) VALUES (2, 'Jens', 'Jensen', 'Karlsmart', 'Rødovrevej 62', 'JJensen@gmail.com', '32155436');
INSERT INTO customer (customer_id, first_name, last_name, username, address, email, phone_number) VALUES (3, 'Ole', 'Olsen', 'Olebole', 'Peterbaksvej 98', 'OOlsen@gmail.com', '75635435');
INSERT INTO customer (customer_id, first_name, last_name, username, address, email, phone_number) VALUES (4, 'Kurt', 'Kurtsen', 'KanKurt', 'Syvhøjvænge 87', 'KKurtsen@gmail.com', '12673112');
INSERT INTO customer (customer_id, first_name, last_name, username, address, email, phone_number) VALUES (5, 'Joakim', 'Olsen', 'heythatsme','Rebæk Søpark 5', 'joakim@gmail.com', '65489087');

INSERT INTO login (login_id, username, password, enabled, role, customer_id, employee_id) VALUES (1, 'heythatsme', '1234', true, 'ROLE_ADMIN', 5, null);