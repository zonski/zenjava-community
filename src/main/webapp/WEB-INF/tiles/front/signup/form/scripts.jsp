<script src="/resources/ext/pwstrength/pwstrength.js"></script>

<script>
    $(document).ready(function () {
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
    });
</script>
