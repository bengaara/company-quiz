
select i.name as "institution name",c.name as "course name",count(s.*) as "number of students" from
institutions i left join course c on c.institution=i.institutionid
left join student s on s.course=c.courseid
group by c.courseid,i.institutionid



CREATE TABLE public.institution (
                                institutionid int(11) NOT null AUTO_INCREMENT,
                                name varchar(250) not null,
                                CONSTRAINT "primary" PRIMARY KEY (institutionid ASC)
);

CREATE TABLE public.course (
                                courseid int(11) NOT null AUTO_INCREMENT,
                                name varchar(250) not null,
                                institution int(11) NULL,
                                CONSTRAINT "primary" PRIMARY KEY (courseid ASC)
);
ALTER TABLE public.course ADD CONSTRAINT course_institution FOREIGN KEY (institution) REFERENCES institution(id);

CREATE TABLE public.student (
                                studentid int(11) NOT null AUTO_INCREMENT,
                                name varchar(250) not null,
                                course int(11) NULL,
                                CONSTRAINT "primary" PRIMARY KEY (studentid ASC)
);
ALTER TABLE public.student ADD CONSTRAINT student_course FOREIGN KEY (course) REFERENCES course(id);