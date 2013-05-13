--------------------------------------------------------------------------------
-- SCHEMA_UPDATE - internal for keeping track of database schema version
--------------------------------------------------------------------------------

CREATE TABLE schema_update (
  version          numeric NOT NULL PRIMARY KEY,
  update_script    text NOT NULL,
  updated_on       timestamp without time zone NOT NULL,
  update_comment   text
);

-- insert the version of this script
insert into SCHEMA_UPDATE (version, update_script, updated_on, update_comment)
values (1.0, 'create-community-schema.sql', now(), 'Create Community Centre Schema script, version 1.0');

--------------------------------------------------------------------------------
-- SYSTEM_INFO
--------------------------------------------------------------------------------

CREATE TABLE system_info
(
  id                  bigserial NOT NULL PRIMARY KEY,
  name                text,
  description         text,
  base_url            text,
  email_server        text,
  email_port          text,
  email_username      text,
  email_password      text
);

--------------------------------------------------------------------------------
-- USER_ACCOUNT
--------------------------------------------------------------------------------

CREATE TABLE user_account
(
  id                    bigserial NOT NULL PRIMARY KEY,
  username              text,
  email                 text,
  password              text,
  activation_code       text,
  activated             boolean,
  first_name            text,
  last_name	            text
);

--------------------------------------------------------------------------------
-- ROLE
--------------------------------------------------------------------------------

CREATE TABLE role
(
  id              bigserial NOT NULL PRIMARY KEY,
  name            text,
  description     text,
  auto_assign     boolean
);

--------------------------------------------------------------------------------
-- USER_ROLE
--------------------------------------------------------------------------------

CREATE TABLE user_role (
  role_id       bigint NOT NULL REFERENCES role ON DELETE RESTRICT,
  user_id       bigint NOT NULL REFERENCES user_account ON DELETE CASCADE
);


--------------------------------------------------------------------------------
-- ROLE_PERMISSION
--------------------------------------------------------------------------------

CREATE TABLE role_permission (
  role_id       bigint NOT NULL REFERENCES role ON DELETE CASCADE,
  permission    text
);


