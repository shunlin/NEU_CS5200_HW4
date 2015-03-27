<%@ page import="java.sql.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.*" %>
<%@ page import="model.*" %>
<%--
  Created by IntelliJ IDEA.
  User: shunlin
  Date: 3/26/15
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    UserManager um = new UserManager();
    User user = new User("username", "password", "firstname", "lastname", "email", new Date(1));
    //um.createUser(user);

    MovieManager mm = new MovieManager();
    Movie movie = new Movie("movieId", "title", "posterImage", new Date(1));
    //mm.createMovie(movie);

    //CommentManager cm = new CommentManager();
    Comment comment = new Comment(-1, "comment", new Date(1), "username", "movieId");

    //cm.createComment(comment);

    ActorManager am = new ActorManager();
    Actor actor = new Actor("actorId", "fn", "ln", new Date(1));
    //am.createActor(actor);

    CastManager cm = new CastManager();
    Cast cast = new Cast(-1, "chN", "movieId", "actorId");
    cm.createCast(cast);

    List<Cast> comments = cm.readAllCast();
    for (Cast u : comments) {
        System.out.println(u.getActorId());
        System.out.println(u.getMovieId());
        System.out.println(u.getCharacterName());
        System.out.println(u.getCastId());
    }
    System.out.println(cm.readCastForId(1).getActorId());
    cast.setCharacterName("nnn");
    cm.updateCast(1, cast);
    System.out.println(cm.readCastForId(1).getCharacterName());
    cm.deleteCast(1);
    System.out.println(cm.readAllCast().size());
%>
</body>
</html>
