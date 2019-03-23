SUMMARY = "The blackmagic distro image"

require console-image.bb

IMAGE_INSTALL += " \
            ethtool \
            phytool \
            mmc-utils \
            iproute2 \
            wf111-driver \
	    wireless-tools \
	    libnl \
"

export IMAGE_BASENAME = "blackmagic-image"
