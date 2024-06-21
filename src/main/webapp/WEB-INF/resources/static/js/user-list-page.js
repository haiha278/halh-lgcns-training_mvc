function confirmDeleteUser(username) {
    console.log("username" + username);
    var result = confirm("Are you sure you want to delete this user?");
    if (result) {
        window.location.href = "/delete-user?username=" + username;
    }
}
