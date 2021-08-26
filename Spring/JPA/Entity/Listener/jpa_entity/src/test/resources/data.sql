call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`,`active`) values (1, 'martin', 'martin@fastcampus.com', now(), now(),true);

call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`,`active`) values (2, 'dennis', 'dennis@fastcampus.com', now(), now(),true);

call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`,`active`) values (3, 'sophia', 'sophia@slowcampus.com', now(), now(),false);

call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`,`active`) values (4, 'james', 'james@slowcampus.com', now(), now(),false);

call next value for hibernate_sequence;
insert into user (`id`, `name`, `email`, `created_at`, `updated_at`,`active`) values (5, 'martin', 'martin@another.com', now(), now(),true);