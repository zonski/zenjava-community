<script src="/resources/ext/pwstrength/pwstrength.js"></script>

<script>
    $(document).ready(function () {

        // password strength indicator
        var options = {
            onKeyUp: function (evt) {
                $(evt.target).pwstrength("outputErrorList");
            },
            viewports: {
                progress: "#password-progress",
                verdict: "#password-verdict",
                errors: "#password-errors"
            }
        };
        $('#password').pwstrength(options);

        // check username
        $("#check-username-btn").click (function () {

            var username = $("#username").val();
            alert("Checking username: " + username);
            $.ajax({
                type: "POST", // or GET
                url: "/checkusername.ajax",
                data: "username=" + username,
                success: function(data){
                    if (data == true) {
                        $("#check-username-result").html("<span class='label label-success'>Available</span>");
                    } else {
                        $("#check-username-result").html("<span class='label label-important'>Not Available</span>");
                    }
                }
            });
            return false; // stop the browser following the link
        });

    });



</script>
