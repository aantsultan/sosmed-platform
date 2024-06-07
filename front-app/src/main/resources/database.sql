CREATE TABLE trx_post (
    posting_id VARCHAR(100) NOT NULL,
    content VARCHAR(255) NOT NULL,
    is_public BIT DEFAULT false,
    only_friend BIT DEFAULT false,
    is_deleted BIT DEFAULT false,
    created_date TIMESTAMP,
    created_by VARCHAR(100),
    modified_date TIMESTAMP,
    modified_by VARCHAR(100),
    PRIMARY KEY (posting_id)
) ENGINE InnoDB;

select * from trx_post;

CREATE TABLE trx_comment (
    comment_id VARCHAR(100) NOT NULL,
    content VARCHAR(100) NOT NULL ,
    parent_id VARCHAR(100) NULL ,
    post_id VARCHAR(100) NOT NULL,
    is_deleted BIT DEFAULT false,
    created_date TIMESTAMP,
    created_by VARCHAR(100),
    modified_date TIMESTAMP,
    modified_by VARCHAR(100),
    PRIMARY KEY (comment_id),
    FOREIGN KEY fk_posts_comments(post_id) REFERENCES trx_post(posting_id),
    FOREIGN KEY fl_comments_parents(parent_id) REFERENCES trx_comment(comment_id)
) ENGINE InnoDB

select * from trx_comment;

CREATE TABLE m_user (
    user_id VARCHAR(100) NOT NULL ,
    name VARCHAR(255) NOT NULL ,
    username VARCHAR(100) NOT NULL ,
    password VARCHAR(255) NOT NULL ,
    email VARCHAR(100) NOT NULL ,
    phone VARCHAR(20) NOT NULL ,
    is_deleted BIT DEFAULT false,
    created_date TIMESTAMP,
    created_by VARCHAR(100),
    modified_date TIMESTAMP,
    modified_by VARCHAR(100),
    PRIMARY KEY (user_id),
    UNIQUE (username, email, phone)
) ENGINE InnoDB;

ALTER TABLE m_user
ADD COLUMN name VARCHAR(255);

-- drop table m_user;

select * from m_user;

CREATE TABLE trx_user_friendlist (
    friendlist_id VARCHAR(100) NOT NULL ,
    user_id VARCHAR(100) NOT NULL,
    friend_id VARCHAR(100) NOT NULL ,
    primary key (friendlist_id),
    FOREIGN KEY fk_friendlist_user(user_id) REFERENCES m_user(user_id),
    FOREIGN KEY fk_friendlist_friend(friend_id) REFERENCES m_user(user_id)
) ENGINE InnoDB

select * from trx_user_friendlist;

CREATE TABLE trx_approval (
    approval_id VARCHAR(100) NOT NULL ,
    type VARCHAR(20) NOT NULL ,
    status VARCHAR(20) NOT NULL ,
    data VARCHAR(255) NOT NULL ,
    assign_to VARCHAR(100) NOT NULL ,
    is_deleted BIT DEFAULT false,
    created_date TIMESTAMP,
    created_by VARCHAR(100),
    modified_date TIMESTAMP,
    modified_by VARCHAR(100),
    primary key (approval_id)
) ENGINE InnoDB;

-- drop table trx_approval;

select * from trx_approval;

CREATE TABLE trx_notification (
    notification_id VARCHAR(100) NOT NULL ,
    type VARCHAR(100) ,
    content VARCHAR(100) ,
    assign_to VARCHAR(100),
    is_read BIT DEFAULT false,
    is_deleted BIT DEFAULT false,
    created_date TIMESTAMP,
    created_by VARCHAR(100),
    modified_date TIMESTAMP,
    modified_by VARCHAR(100),
    primary key (notification_id)
) ENGINE InnoDB;

select * from trx_notification;