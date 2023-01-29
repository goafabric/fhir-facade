location /callees/sayMyName {
    default_type application/json;
    return 200 '{ "message": "Your name is: Heisenberg" }';
}