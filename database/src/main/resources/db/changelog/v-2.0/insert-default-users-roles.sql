INSERT INTO `user_roles`(`user_id`, `role_id`)
SELECT (SELECT id FROM `users` WHERE `login` = 'admin'), (SELECT id FROM `roles` WHERE `name` = 'ROLE_ADMIN')
UNION ALL
SELECT (SELECT id FROM `users` WHERE `login` = 'user1'), (SELECT id FROM `roles` WHERE `name` = 'ROLE_GUEST');
GO