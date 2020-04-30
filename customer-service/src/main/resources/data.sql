insert into identity(id, identification_number)
    values (2000, 'A123456');
insert into identity(id, identification_number)
    values (2001, 'B123456');
insert into identity(id, identification_number)
    values (2002, 'C123456');

insert into customer(id, first_name, last_name, user_name, created_date, update_date, identity_id)
    values (1000, 'raj', 'kumar', 'rajkumar@gmail.com', sysdate, sysdate, 2000);
insert into customer(id, first_name, last_name, user_name, created_date, update_date, identity_id)
    values (1001, 'ram', 'krish', 'ramkrish@gmail.com', sysdate, sysdate, 2001);
insert into customer(id, first_name, last_name, user_name, created_date, update_date, identity_id)
    values (1002, 'sri', 'kumar', 'srikumar@gmail.com', sysdate, sysdate, 2002);


insert into address(id, line1, line2, city, state, zipcode, country)
    values (3000, 'american ave', 'apt 100', 'richmond', 'VA' ,'01122', 'USA');
insert into address(id, line1, line2, city, state, zipcode, country)
    values (3001, 'allendale ave', 'apt 200', 'newyork', 'NY','23456', 'USA');
insert into address(id, line1, line2, city, state, zipcode, country)
    values (3002, 'kings street', 'apt 300', 'dallas', 'TX', '91234', 'USA');

