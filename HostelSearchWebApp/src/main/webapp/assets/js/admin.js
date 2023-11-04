function searchPosts() {
    var input = removeDiacritics(document.getElementById("postSearchQuery").value.toLowerCase());
    var tableBody = document.getElementById("postsTableBody");
    var rows = tableBody.getElementsByTagName("tr");

    for (var i = 0; i < rows.length; i++) {
        var id = removeDiacritics(rows[i].getElementsByTagName("td")[0].innerText.toLowerCase());
        var title = removeDiacritics(rows[i].getElementsByTagName("td")[1].innerText.toLowerCase());

        if (title.includes(input) || id.includes(input)) {
            rows[i].style.display = "";
        } else {
            rows[i].style.display = "none";
        }
    }
}
function searchUsers() {
    var input = removeDiacritics(document.getElementById("userSearchQuery").value.toLowerCase());
    var tableBody = document.getElementById("usersTableBody");
    var rows = tableBody.getElementsByTagName("tr");

    for (var i = 0; i < rows.length; i++) {
        var id = removeDiacritics(rows[i].getElementsByTagName("td")[0].innerText.toLowerCase()); // Lấy giá trị ID từ cột đầu tiên của bảng
        var fullName = removeDiacritics(rows[i].getElementsByTagName("td")[2].innerText.toLowerCase());


        if (fullName.includes(input) || id.includes(input)) {
            rows[i].style.display = "";
        } else {
            rows[i].style.display = "none";
        }
    }
}
// Lấy tham chiếu đến ô tìm kiếm
var searchInput = document.getElementById("userSearchQuery");

// Gắn sự kiện keyup vào ô tìm kiếm
searchInput.addEventListener("keyup", function () {
    searchUsers();
});
function searchHostel() {
    var input = removeDiacritics(document.getElementById("hostelSearchQuery").value.toLowerCase());
    var tableBody = document.getElementById("hostelTableBody");
    var rows = tableBody.getElementsByTagName("tr");

    for (var i = 0; i < rows.length; i++) {
        var id = removeDiacritics(rows[i].getElementsByTagName("td")[0].innerText.toLowerCase()); // Lấy giá trị ID từ cột đầu tiên của bảng
        var hostelName = removeDiacritics(rows[i].getElementsByTagName("td")[1].innerText.toLowerCase());


        if (hostelName.includes(input) || id.includes(input)) {
            rows[i].style.display = "";
        } else {
            rows[i].style.display = "none";
        }
    }
}

function removeDiacritics(text) {
    return text.normalize("NFD").replace(/[\u0300-\u036f]/g, "");
}

function updatePost(postId) {
    // Perform the necessary logic to update the post
    // For example, you can redirect to an update page with the post ID
    window.location.href = "updatePost?id=" + postId;
}

function deletePost(postId) {
    // Perform the necessary logic to update the post
    // For example, you can redirect to an update page with the post ID
    window.location.href = "deletePost?id=" + postId;
}
//User ADMIN PAGE
function addUser() {
    // Perform the necessary logic to update the post
    // For example, you can redirect to an update page with the post ID
    window.location.href = "addUser";
}

function updateUser(userId) {
    // Perform the necessary logic to update the post
    // For example, you can redirect to an update page with the post ID
    window.location.href = "updateUser?id=" + userId;
}

//function deleteUser(userId) {
//    // Perform the necessary logic to update the post
//    // For example, you can redirect to an update page with the post ID
//    if(confirm("Bạn có chắc sẽ xóa người dùng này không? ") + userId){
//        window.location.href = "deleteUser?id=" + userId;
//    }
//    
//}

//User ADMIN PAGE END
/////////////////////////////////////////
//HOSTEL ADMIN PAGE
function addHostel() {
    // Perform the necessary logic to update the post
    // For example, you can redirect to an update page with the post ID
    window.location.href = "addUser";
}

function updateHostel(hostelId) {
    // Perform the necessary logic to update the post
    // For example, you can redirect to an update page with the post ID
    window.location.href = "updateUser?id=" + hostelId;
}

function deleteHostel(hostelId) {
    // Perform the necessary logic to update the post
    // For example, you can redirect to an update page with the post ID
    if (confirm("Bạn có chắc sẽ xóa người dùng này không? ") + hostelId) {
        window.location.href = "deleteUser?id=" + hostelId;
    }

}
///HOSTEL ADMIN PAGE END
function setDefaultUserType() {
    var userTypeSelect = document.getElementById("userType");
    var selectedValue = userTypeSelect.value;

    if (selectedValue === "") {
        // Nếu không có giá trị được chọn, thiết lập giá trị mặc định là "admin"
        userTypeSelect.value = "admin";
    }
}
function selectRole(role) {
    document.getElementById("userType").value = role;
    // Optional: You can add visual cues to indicate the selected role, for example, changing button styles.
    if (role === "admin") {
        document.getElementById("adminButton").classList.add("selected");
        document.getElementById("normalButton").classList.remove("selected");
    } else {
        document.getElementById("adminButton").classList.remove("selected");
        document.getElementById("normalButton").classList.add("selected");
    }
}





