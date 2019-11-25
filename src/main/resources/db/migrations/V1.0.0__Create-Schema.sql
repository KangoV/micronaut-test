create table build (id uuid not null, created timestamp, name varchar(255), primary key (id));
create table build_dependency (build_id uuid not null, component_name varchar(255));
create table build_label (build_id uuid not null, label_name varchar(255), label_type varchar(255) not null, primary key (build_id, label_type));
create table build_property (build_id uuid not null, property_name varchar(255), property_key varchar(255) not null, primary key (build_id, property_key));
create table component (id uuid not null, created timestamp, name varchar(255), componentdef_id uuid, primary key (id));
create table component_label (build_id uuid not null, label_name varchar(255), label_type varchar(255) not null, primary key (build_id, label_type));
create table component_property (build_id uuid not null, property_name varchar(255), property_key varchar(255) not null, primary key (build_id, property_key));
create table componentdefinition (id uuid not null, created timestamp, name varchar(255), componentdef_dependency_id uuid, primary key (id));

alter table if exists build_dependency add constraint FK_bd_build_id foreign key (build_id) references build;
alter table if exists build_label add constraint FK_bl_build_id foreign key (build_id) references build;
alter table if exists build_property add constraint FK_bp_build_id foreign key (build_id) references build;
alter table if exists component add constraint FK_c_componentdefinition_id foreign key (componentdef_id) references componentdefinition;
alter table if exists component_label add constraint FKFK_cl_componentdefinition_id foreign key (build_id) references component;
alter table if exists component_property add constraint FK_cp_componentdefinition_id foreign key (build_id) references component;
--alter table if exists componentdefinition add constraint FK_cd_component_id foreign key (componentdef_dependency_id) references component;


create table part (id uuid not null, name varchar(255), attributes text, created timestamp, primary key (id));
create table partref (id uuid not null, subtype varchar(20), part_id uuid, primary key(id)); 
alter table if exists partref add constraint FK_pr_part_id foreign key (part_id) references part;


